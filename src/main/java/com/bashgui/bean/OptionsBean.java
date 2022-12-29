package com.bashgui.bean;

/**
 * @date: 2022/12/26 18:00
 * @description:
 */
public class OptionsBean {
    private String rhost;
    private String rport;
    private String lhost;
    private String lport;
    private String DnsLog;
    private String Command;



    public String getRhost() {
        return rhost;
    }

    public void setRhost(String rhost) {
        this.rhost = rhost;
    }

    public String getRport() {
        return rport;
    }

    public void setRport(String rport) {
        this.rport = rport;
    }

    public String getLhost() {
        return lhost;
    }

    public void setLhost(String lhost) {
        this.lhost = lhost;
    }

    public String getLport() {
        return lport;
    }

    public void setLport(String lport) {
        this.lport = lport;
    }

    public String getDnsLog() {
        return DnsLog;
    }

    public void setDnsLog(String dnsLog) {
        DnsLog = dnsLog;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }




}
