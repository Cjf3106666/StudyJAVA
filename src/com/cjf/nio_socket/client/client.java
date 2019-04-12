package com.cjf.nio_socket.client;

import com.cjf.demo.nio_socket.tools.CharSetUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/4/12 9:54
 **/
public class client {
    private SocketChannel channel = null;
    private ByteBuffer send = ByteBuffer.allocate(1024);
    private ByteBuffer rece = ByteBuffer.allocate(1024);
    private Selector selector;
    static private Logger logger = Logger.getLogger(client.class);

    public client() throws IOException {
        channel = SocketChannel.open();
        channel.socket().connect(new InetSocketAddress("localhost", 6666));
        channel.configureBlocking(false);

        logger.info("与服务器建立连接成功");
        selector = Selector.open();
    }

    public void talk() throws IOException {
        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = null;
                try {
                    selectionKey = (SelectionKey) iterator.next();
                    iterator.remove();
                    if (selectionKey.isReadable()) {
                        dealWithReadable(selectionKey);
                    }
                    if (selectionKey.isWritable()) {
                        dealWithWritable(selectionKey);
                    }
                } catch (Exception e) {
                    if (selectionKey != null) {
                        selectionKey.cancel();
                        try {
                            selectionKey.channel().close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void receFromUser() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        while ((msg = bufferedReader.readLine()) != null) {
            synchronized (send) {
                send.put(CharSetUtils.enCode(msg + "\r\n", "UTF-8"));
            }
            if ("bye".equalsIgnoreCase(msg)) {
                break;
            }
        }
    }

    private void dealWithWritable(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        synchronized (send) {
            send.flip();
            channel.write(send);
            send.compact();
        }
    }

    private void dealWithReadable(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        channel.read(rece);
        rece.flip();
        String msg = CharSetUtils.deCode(rece, "UTF-8");

        if (msg.indexOf("\r\n") == -1) {
            return;
        }

        String outPutData = msg.substring(0, msg.indexOf("\n") + 1);
        logger.info(outPutData);

        if ("echo:bye\r\n".equalsIgnoreCase(outPutData)) {
            selectionKey.cancel();
            channel.close();
            selector.close();
            logger.info("关闭与客户端的连接");
        }

        ByteBuffer tmp = CharSetUtils.enCode(outPutData, "UTF-8");
        rece.position(tmp.limit());
        rece.compact();
    }

    public static void main(String[] args) throws IOException {
        logger.info(System.getProperty("file.encoding"));
        final client noBlockingClient = new client();
        Thread thread = new Thread(() -> {
            try {
                noBlockingClient.receFromUser();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        noBlockingClient.talk();
    }
}