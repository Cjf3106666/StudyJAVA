package com.cjf.demo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo22_NIO {
    public static void main(String[] args) throws IOException {
      //  Demo01();
       // Demo02();
        //Demo03();
        Demo04();

    }

    private static void Demo04() {
        char[] data = "0123456789".toCharArray();
        ByteBuffer buffer = ByteBuffer.allocate(data.length * 2);
        CharBuffer charBuffer = buffer.asCharBuffer();
        charBuffer.put(data);
        charBuffer.rewind();
        System.out.println(charBuffer);
        while (charBuffer.hasRemaining()) {
            charBuffer.mark();
            char a1 = charBuffer.get();
            if (charBuffer.hasRemaining()) {
                char a2 = charBuffer.get();
                System.out.println(a1 + "  " + a2);
                charBuffer.reset();
                charBuffer.put(a2).put(a1);
            }
        }
        System.out.println(charBuffer.rewind());
    }

    private static void Demo03() {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[1024]);
        System.out.println(buffer.capacity() + " " + buffer.limit() + " " + buffer.position());
        //  buffer.asCharBuffer().put("asdasdasd");
        //  buffer.mark();
        // buffer.asCharBuffer().put("asdasdasd");

        buffer.put("asdasdas".getBytes());
        //  buffer.rewind();
        //  buffer.flip();
        buffer.put("asdasdaas".getBytes());
        System.out.println(Arrays.toString(buffer.array()));
        System.out.println(buffer.capacity() + " " + buffer.limit() + " " + buffer.position());
    }

    private static void Demo02() throws IOException {
        FileChannel in = new FileInputStream("res/test.txt").getChannel(),
                out = new FileOutputStream("456.html").getChannel();
        // in.transferTo(0,in.size(),out);
        out.transferFrom(in, 0, in.size());
    }

    private static void Demo01() throws IOException {
        FileChannel fc = new FileOutputStream("res\\test.txt").getChannel();
        fc.write(ByteBuffer.wrap("Hello world ".getBytes()));
        fc.close();
        fc = new RandomAccessFile("res\\test.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("EveryThing Will be OK".getBytes()));
        fc.close();
        fc = new FileInputStream("res\\test.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        fc.read(buff);

        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }
    }
}
