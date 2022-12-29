package com.swordHostDemo.utls;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @date: 2022/12/29 20:25
 * @description:
 */
public class DeCode {
    public static String base64Decode(String str) {
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
