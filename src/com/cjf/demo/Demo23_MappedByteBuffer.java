package com.cjf.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Demo23_MappedByteBuffer {
    public static void main(String[] args) throws IOException {
        int length = 0xFFFFF;
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'a');
        }
        System.out.println("Writer OK!");
        for (int i = length / 3; i < length / 3 + 10; i++) {
            System.out.println((char) out.get(i));
        }
        out.clear();

    }

}
