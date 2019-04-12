package com.cjf.nio_socket.server;

import com.cjf.demo.nio_socket.tools.CharSetUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/4/12 9:32
 **/
public class server {

    private static final int PORT = 6666;
    private ServerSocketChannel serverSocketChannel = null;
    private Selector selector = null;

    static private Logger logger = Logger.getLogger(server.class);

    public server() throws IOException {
        logger.info("正在启动Server 服务器...");
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().setReuseAddress(true);
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
        logger.info("Server 服务器启动成功...");
    }

    public void service() throws IOException {
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = null;
                try {
                    selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isAcceptable()) {
                        dealWithAcceptable(selectionKey);
                    }
                    if (selectionKey.isReadable()) {
                        dealWithReadable(selectionKey);
                    }
                    if (selectionKey.isWritable()) {
                        dealWithWritable(selectionKey);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (selectionKey != null) {
                        selectionKey.cancel();
                        selectionKey.channel().close();
                    }
                }

            }
        }
    }

    private void dealWithAcceptable(SelectionKey selectionKey)
            throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey
                .channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        logger.info("接收到来自： " + socketChannel.socket().getInetAddress()
                + " :" + socketChannel.socket().getPort() + " 的请求");
        socketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ
                | SelectionKey.OP_WRITE, buffer);
    }

    private void dealWithReadable(SelectionKey selectionKey) throws IOException {
        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer readBuffer = ByteBuffer.allocate(32);
        channel.read(readBuffer);
        readBuffer.flip();

        buffer.limit(buffer.capacity());
        buffer.put(readBuffer);
    }

    private void dealWithWritable(SelectionKey selectionKey) throws IOException {
        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        buffer.flip();

        String msg = CharSetUtils.deCode(buffer, "UTF-8");
        if (msg.indexOf("\r\n") == -1) {
            return;
        }
        String outPutData = msg.substring(0, msg.indexOf("\n") + 1);
        logger.info("接收来自客户端的数据：" + outPutData);

        ByteBuffer outbyteBuffer = CharSetUtils.enCode("echo:" + outPutData, "UTF-8");
        while (outbyteBuffer.hasRemaining()) {
            channel.write(outbyteBuffer);
        }

        ByteBuffer tmp = CharSetUtils.enCode(outPutData, "UTF-8");
        buffer.position(tmp.limit());
        buffer.compact();
        if ("bye\r\n".equalsIgnoreCase(outPutData)) {
            selectionKey.cancel();
            channel.close();
            logger.info("关闭与客户端的连接");
        }
    }

    public static void main(String[] args) throws IOException {
        new server().service();
    }

}
