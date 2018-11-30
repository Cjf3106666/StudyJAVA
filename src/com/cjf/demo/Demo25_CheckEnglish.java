package com.cjf.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo25_CheckEnglish {
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
                //  int x=line.indexOf('=');
                // line=line.substring(x+1);
                sb.append(line + "\n");
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接

           /*PrintWriter pw=new PrintWriter(new FileWriter("result"));
            pw.print(sb.toString());
            pw.flush();
            pw.close();*/

            FileChannel fileChannel = new FileOutputStream("").getChannel();
            ByteBuffer buffer = ByteBuffer.wrap(sb.toString().getBytes());
            fileChannel.write(buffer);
            fileChannel.close();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws IOException {
       // long begin = System.currentTimeMillis();
        httpURLConectionGET();
        checkEN();
      //  long end = System.currentTimeMillis();
       // System.out.println(end - begin);
    }

    static public void checkEN() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(""));
        StringBuilder sb = new StringBuilder();
        String temp = null;
        int linenum = 0;
        while ((temp = br.readLine()) != null) {
            linenum++;
            int x = temp.indexOf('=');
            String tempstr = temp.substring(x + 1);
            for (int i = 0; i < tempstr.length(); i++) {
                char c = tempstr.charAt(i);
                if (c > 128) {
                }
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("checkResult"));
        pw.write(sb.toString());
        pw.close();
        br.close();
        System.out.println(sb);

    }

}
