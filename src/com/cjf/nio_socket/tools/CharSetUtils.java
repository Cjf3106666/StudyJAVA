package com.cjf.nio_socket.tools;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/4/12 9:33
 **/
public class CharSetUtils {

    /**
     * 解码
     * @param buffer
     * @param charsetName
     * @return
     */
    public static String deCode(ByteBuffer buffer, String charsetName) {
        Charset charset = Charset.forName(charsetName);
        CharBuffer msg = charset.decode(buffer);
        return msg.toString();
    }

    /**
     * 编码
     * @param msg
     * @param charsetName
     * @return
     */
    public static ByteBuffer enCode(String msg, String charsetName) {
        Charset charset = Charset.forName(charsetName);
        ByteBuffer byteBuffer = charset.encode(msg);
        return byteBuffer;

    }
}
