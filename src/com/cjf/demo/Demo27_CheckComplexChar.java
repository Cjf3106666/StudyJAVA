package com.cjf.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo27_CheckComplexChar {
    public static void main(String[] args) throws IOException {
        //  long begin = System.currentTimeMillis();
        httpURLConectionGET();
        checkComplexChar();
        // long end = System.currentTimeMillis();
        //System.out.println(end - begin);

    }

    public static void httpURLConectionGET() {

        try {
            URL url = new URL("");    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流

                sb.append(line + "\n");
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接

            FileChannel fileChannel = new FileOutputStream("").getChannel();
            ByteBuffer buffer = ByteBuffer.wrap(sb.toString().getBytes());
            fileChannel.write(buffer);
            fileChannel.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }

    }

    private static void checkComplexChar() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(""));
        BufferedWriter bw = new BufferedWriter(new FileWriter("简繁转换结果"));
        StringBuilder sb = new StringBuilder();
        String temp = null;
        int i = 0;
        while ((temp = br.readLine()) != null) {
            i++;
            try {
                String[] strs = temp.split("=");
                if (strs[0].length() == strs[0].getBytes().length) {
                    continue;
                }
                String TempResult = Demo28_简繁转换工具.traditionalized(strs[0]).trim();
                if (!TempResult.equals(strs[1].trim())) {

                }
            } catch (Exception e) {
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
