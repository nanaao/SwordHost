package com.bashgui.controller;

/**
 * @date: 2022/12/26 22:01
 * @description:
 */
public class Proxy {


    public static String Stowaway(String lhost,String lport,String rport ,String s){
        //admin
        String adminStr = "./linux_x64_admin -l "+rport+ " -s "+ s;
        //Linux agent
        String LinuxAgent = "./.XC-unix -c "+ lhost+":"+ lport +" -s " + s + " --reconnect 10";

        //Windows agent
        String WindowsAgent = "windows_x64_agent.exe -c "+ lhost+":"+ lport +" -s " + s + " --reconnect 10";

        String res = adminStr +"\n\r"+ LinuxAgent +"\n\r"+WindowsAgent;
        return res;
    }
}
