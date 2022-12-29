package com.bashgui.dao;

import com.bashgui.bean.OptionsBean;
import com.bashgui.controller.base64Code;
import com.bashgui.controller.MsfShell;
import com.bashgui.controller.Proxy;

/**
 * @date: 2022/12/27 9:31
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        OptionsBean OptionsBean = new OptionsBean();
        //测试数据
        String Lhost = "127.0.0.1";
        String Lport = "24652";
        String Dnslog = "asdf134.dnslog.cn";
        String Command = "whoami";
        String Rhost = "24.21.1.1";
        String Rport = "2134";

        OptionsBean.setLhost(Lhost);
        OptionsBean.setLport(Lport);
        OptionsBean.setCommand(Command);
        OptionsBean.setDnsLog(Dnslog);
        OptionsBean.setRhost(Rhost);
        OptionsBean.setRport(Rport);

        String lhost = OptionsBean.getLhost();
        String lport = OptionsBean.getLport();
        String rport = OptionsBean.getRport();
        String rhost = OptionsBean.getLhost();
        String dnslog = OptionsBean.getDnsLog();
        String command = OptionsBean.getCommand();


        //test base64Code
        System.out.println(base64Code.JavaEncode(lhost,lport));

        //test proxy
        String res = Proxy.Stowaway(lhost,lport,rport,"1234132");
        System.out.println(res);

        //test msf
        MsfShell msfShell = new MsfShell();
        System.out.println(msfShell.MsfCommand(lhost, lport));
    }


}
