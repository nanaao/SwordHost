/*
 * Created by JFormDesigner on Tue Dec 27 14:58:35 CST 2022
 */

package com.swordHostDemo.view;

import com.swordHostDemo.controller.*;
import com.swordHostDemo.utls.DeCode;
import com.swordHostDemo.utls.EnCode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

/**
 * @author DXAJUI
 */
public class jFormGUI extends JFrame {
    public jFormGUI() {
        initComponents();
    }

    public void init() {
        ReverseMenu();
        StowawayMenu();
        msfShellMenu();
        FastjsonMenu();
        Log4j2Menu();
    }

    //Reverse
    public void ReverseMenu() {
        //BashOption
        String baseOption = Reverse.ReverseBash(LhostValue.getText(), LportValue.getText());
        BashTextArea.setText(baseOption);

        //JavaBashOption
        String javaBashOption = EnCode.JavaEncode(LhostValue.getText(), LportValue.getText());
        JavaBashTextArea.setText(javaBashOption);
    }

    public void msfShellMenu() {
        //Linux
        String msf = MsfShell.MsfCommand(LhostValue.getText(), LportValue.getText());
        msfTextArea.setText(msf);
    }

    public void StowawayMenu() {

        String stowaway = Proxy.Stowaway(LhostValue.getText(), LportValue.getText(), RportVaule.getText(), "243141");
        StowayTextArea.setText(stowaway);

    }

    public void FastjsonMenu() {
        //FastjsonOption
        String fastjsonOption = Fastjson.fastjsonEXP1(LhostValue.getText(), LportValue.getText());
        FaEXP1TextArea.setText(fastjsonOption);
        //FaDNSlogOption
        String faDNSlogOption = Fastjson.fastjsonDnslog(DNSlogValue.getText());
        FaDNSlogTextArea.setText(faDNSlogOption);
    }


    public void Log4j2Menu() {
        //Log4j2Option
        String Log4j2Option = Log4j2.LoIPlog4j2(LhostValue.getText(), LportValue.getText());
        LoIPTextArea.setText(Log4j2Option);
        //Log4j2DNSlogOption
        String Log4j2DNSlogOption = Log4j2.LoDnslog4j2(DNSlogValue.getText());
        LoDNSlogTextArea.setText(Log4j2DNSlogOption);

    }


    //Lhost
    private void LhostValueKeyReleased(KeyEvent e) {
        // TODO add your code here
        //测试
        String Lhost = LhostValue.getText();
        System.out.println(Lhost);
        //调用方法
        init();
    }


    //Lport
    private void LportValueKeyReleased(KeyEvent e) {
        // TODO add your code here
        //测试
        String Lport = LportValue.getText();
        System.out.println(Lport);
        //调用方法
        init();
    }

    //Dnslog
    private void DNSlogValueKeyReleased(KeyEvent e) {
        // TODO add your code here
        //测试
        String dnslog = DNSlogValue.getText();
        System.out.println(dnslog);
        //调用方法
        init();
    }


    //Rhost
    private void RhostValueKeyReleased(KeyEvent e) {
        // TODO add your code here
        //测试
        String rhost = RhostValue.getText();
        System.out.println(rhost);
        //调用方法
        init();
    }


    //Rport
    private void RportVauleKeyReleased(KeyEvent e) {
        //测试
        String rport = RportVaule.getText();
        System.out.println(rport);
        //调用方法
        init();

    }

    //Command
    private void CommandVauleKeyReleased(KeyEvent e) {
        // TODO add your code here
        //测试
        String command = CommandVaule.getText();
        System.out.println(command);
        //调用方法
    }


    private void Babut2DeCodeMouseClicked(MouseEvent e) {
        // TODO add your code here
        // TODO add your code here
        String Base64DeText = Base64EnsTextArea.getText();
        String vaule = DeCode.base64Decode(Base64DeText);
        Bas64DeTextArea.setText(vaule);
    }

    private void Babut1EnCodeMouseClicked(MouseEvent e) {
        // TODO add your code here
        String Base64DeText = Base64EnsTextArea.getText();
        String vaule = EnCode.base64Encode(Base64DeText);
        Bas64DeTextArea.setText(vaule);
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        String a = Base64EnsTextArea.getText();
        String b = Bas64DeTextArea.getText();
        String t = a;
        Base64EnsTextArea.setText(t);
        a = b;
        Base64EnsTextArea.setText(a);
        b = t;
        Bas64DeTextArea.setText(b);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("jFormGUI");
        Panel1 = new JPanel();
        LPanel1 = new JPanel();
        LHOST = new JLabel();
        LPORT = new JLabel();
        LhostValue = new JTextField();
        LportValue = new JTextField();
        DNSLog = new JLabel();
        DNSlogValue = new JTextField();
        RPanel2 = new JPanel();
        RHOST = new JLabel();
        RPORT = new JLabel();
        RhostValue = new JTextField();
        RportVaule = new JTextField();
        Command = new JLabel();
        CommandVaule = new JTextField();
        Panel2 = new JPanel();
        JtabbedPanel = new JTabbedPane();
        ReverseMenu = new JTabbedPane();
        BashOption = new JScrollPane();
        BashTextArea = new JTextArea();
        JavaBashOption = new JScrollPane();
        JavaBashTextArea = new JTextArea();
        msfs = new JTabbedPane();
        scrollPane3 = new JScrollPane();
        msfTextArea = new JTextArea();
        Stoways = new JTabbedPane();
        scrollPane2 = new JScrollPane();
        StowayTextArea = new JTextArea();
        scrollPane4 = new JScrollPane();
        downloadTextArea = new JTextArea();
        Fastjsons = new JPanel();
        tabbedPane1 = new JTabbedPane();
        FaVersion = new JScrollPane();
        FaVersionTextArea = new JTextArea();
        FaDNSlog = new JScrollPane();
        FaDNSlogTextArea = new JTextArea();
        FaEXP1 = new JScrollPane();
        FaEXP1TextArea = new JTextArea();
        Log4j2s = new JPanel();
        tabbedPane2 = new JTabbedPane();
        scrollPane8 = new JScrollPane();
        LoDNSlogTextArea = new JTextArea();
        scrollPane9 = new JScrollPane();
        LoIPTextArea = new JTextArea();
        Custom = new JPanel();
        scrollPane5 = new JScrollPane();
        textArea2 = new JTextArea();
        DeCodeAndEnCodes = new JPanel();
        DeAndEnCodeBase64s = new JTabbedPane();
        Base64DeCodes = new JPanel();
        Base64EnsTextArea = new JTextArea();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane10 = new JScrollPane();
        Bas64DeTextArea = new JTextArea();
        Babut1EnCode = new JButton();
        Babut2DeCode = new JButton();
        Base64buttonSwap = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== Panel1 ========
        {
            Panel1.setBorder(new EmptyBorder(12, 12, 12, 12));
            Panel1.setLayout(null);

            //======== LPanel1 ========
            {
                LPanel1.setLayout(null);

                //---- LHOST ----
                LHOST.setText(bundle.getString("LHOST.text"));
                LPanel1.add(LHOST);
                LHOST.setBounds(new Rectangle(new Point(5, 11), LHOST.getPreferredSize()));

                //---- LPORT ----
                LPORT.setText("LPORT");
                LPanel1.add(LPORT);
                LPORT.setBounds(new Rectangle(new Point(190, 10), LPORT.getPreferredSize()));

                //---- LhostValue ----
                LhostValue.setText(bundle.getString("LhostValue.text"));
                LhostValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        LhostValueKeyReleased(e);
                    }
                });
                LPanel1.add(LhostValue);
                LhostValue.setBounds(50, 5, 115, LhostValue.getPreferredSize().height);

                //---- LportValue ----
                LportValue.setText(bundle.getString("LportValue.text"));
                LportValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        LportValueKeyReleased(e);
                    }
                });
                LPanel1.add(LportValue);
                LportValue.setBounds(235, 5, 55, LportValue.getPreferredSize().height);

                //---- DNSLog ----
                DNSLog.setText("DNSLog");
                LPanel1.add(DNSLog);
                DNSLog.setBounds(new Rectangle(new Point(305, 10), DNSLog.getPreferredSize()));

                //---- DNSlogValue ----
                DNSlogValue.setText(bundle.getString("DNSlogValue.text"));
                DNSlogValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        DNSlogValueKeyReleased(e);
                    }
                });
                LPanel1.add(DNSlogValue);
                DNSlogValue.setBounds(375, 5, 105, DNSlogValue.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < LPanel1.getComponentCount(); i++) {
                        Rectangle bounds = LPanel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = LPanel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    LPanel1.setMinimumSize(preferredSize);
                    LPanel1.setPreferredSize(preferredSize);
                }
            }
            Panel1.add(LPanel1);
            LPanel1.setBounds(10, 10, 650, 45);

            //======== RPanel2 ========
            {
                RPanel2.setLayout(null);

                //---- RHOST ----
                RHOST.setText(bundle.getString("RHOST.text"));
                RPanel2.add(RHOST);
                RHOST.setBounds(new Rectangle(new Point(5, 11), RHOST.getPreferredSize()));

                //---- RPORT ----
                RPORT.setText("RPORT");
                RPanel2.add(RPORT);
                RPORT.setBounds(new Rectangle(new Point(190, 10), RPORT.getPreferredSize()));

                //---- RhostValue ----
                RhostValue.setText(bundle.getString("RhostValue.text"));
                RhostValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        RhostValueKeyReleased(e);
                    }
                });
                RPanel2.add(RhostValue);
                RhostValue.setBounds(50, 5, 115, RhostValue.getPreferredSize().height);

                //---- RportVaule ----
                RportVaule.setText(bundle.getString("RportVaule.text"));
                RportVaule.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        RportVauleKeyReleased(e);
                    }
                });
                RPanel2.add(RportVaule);
                RportVaule.setBounds(235, 5, 55, RportVaule.getPreferredSize().height);

                //---- Command ----
                Command.setText("Command");
                RPanel2.add(Command);
                Command.setBounds(new Rectangle(new Point(305, 10), Command.getPreferredSize()));

                //---- CommandVaule ----
                CommandVaule.setText(bundle.getString("CommandVaule.text"));
                CommandVaule.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        CommandVauleKeyReleased(e);
                    }
                });
                RPanel2.add(CommandVaule);
                CommandVaule.setBounds(375, 5, 110, CommandVaule.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < RPanel2.getComponentCount(); i++) {
                        Rectangle bounds = RPanel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = RPanel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    RPanel2.setMinimumSize(preferredSize);
                    RPanel2.setPreferredSize(preferredSize);
                }
            }
            Panel1.add(RPanel2);
            RPanel2.setBounds(10, 60, 650, 45);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < Panel1.getComponentCount(); i++) {
                    Rectangle bounds = Panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = Panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                Panel1.setMinimumSize(preferredSize);
                Panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(Panel1);
        Panel1.setBounds(0, 0, 670, 120);

        //======== Panel2 ========
        {
            Panel2.setBorder(new EmptyBorder(12, 12, 12, 12));
            Panel2.setLayout(null);

            //======== JtabbedPanel ========
            {

                //======== ReverseMenu ========
                {
                    ReverseMenu.setTabPlacement(SwingConstants.LEFT);

                    //======== BashOption ========
                    {
                        BashOption.setViewportView(BashTextArea);
                    }
                    ReverseMenu.addTab("Bash", BashOption);

                    //======== JavaBashOption ========
                    {
                        JavaBashOption.setViewportView(JavaBashTextArea);
                    }
                    ReverseMenu.addTab("JavaBash", JavaBashOption);
                }
                JtabbedPanel.addTab(bundle.getString("ReverseMenu.tab.title"), ReverseMenu);

                //======== msfs ========
                {
                    msfs.setTabPlacement(SwingConstants.LEFT);

                    //======== scrollPane3 ========
                    {
                        scrollPane3.setViewportView(msfTextArea);
                    }
                    msfs.addTab("Linux", scrollPane3);
                }
                JtabbedPanel.addTab(bundle.getString("msfs.tab.title"), msfs);

                //======== Stoways ========
                {
                    Stoways.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                    Stoways.setTabPlacement(SwingConstants.LEFT);

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setComponentPopupMenu(null);
                        scrollPane2.setViewportView(StowayTextArea);
                    }
                    Stoways.addTab("res", scrollPane2);

                    //======== scrollPane4 ========
                    {
                        scrollPane4.setViewportView(downloadTextArea);
                    }
                    Stoways.addTab("download", scrollPane4);
                }
                JtabbedPanel.addTab(bundle.getString("Stoways.tab.title"), Stoways);

                //======== Fastjsons ========
                {
                    Fastjsons.setLayout(new BoxLayout(Fastjsons, BoxLayout.X_AXIS));

                    //======== tabbedPane1 ========
                    {
                        tabbedPane1.setTabPlacement(SwingConstants.LEFT);

                        //======== FaVersion ========
                        {

                            //---- FaVersionTextArea ----
                            FaVersionTextArea.setText(bundle.getString("FaVersionTextArea.text"));
                            FaVersion.setViewportView(FaVersionTextArea);
                        }
                        tabbedPane1.addTab("Version", FaVersion);

                        //======== FaDNSlog ========
                        {
                            FaDNSlog.setViewportView(FaDNSlogTextArea);
                        }
                        tabbedPane1.addTab("DNSlog", FaDNSlog);

                        //======== FaEXP1 ========
                        {
                            FaEXP1.setViewportView(FaEXP1TextArea);
                        }
                        tabbedPane1.addTab("EXP1", FaEXP1);
                    }
                    Fastjsons.add(tabbedPane1);
                }
                JtabbedPanel.addTab(bundle.getString("Fastjsons.tab.title"), Fastjsons);

                //======== Log4j2s ========
                {
                    Log4j2s.setLayout(new BoxLayout(Log4j2s, BoxLayout.X_AXIS));

                    //======== tabbedPane2 ========
                    {
                        tabbedPane2.setTabPlacement(SwingConstants.LEFT);

                        //======== scrollPane8 ========
                        {
                            scrollPane8.setViewportView(LoDNSlogTextArea);
                        }
                        tabbedPane2.addTab("DNSlog", scrollPane8);

                        //======== scrollPane9 ========
                        {
                            scrollPane9.setViewportView(LoIPTextArea);
                        }
                        tabbedPane2.addTab("IP", scrollPane9);
                    }
                    Log4j2s.add(tabbedPane2);
                }
                JtabbedPanel.addTab(bundle.getString("Log4j2s.tab.title"), Log4j2s);

                //======== Custom ========
                {
                    Custom.setLayout(new BoxLayout(Custom, BoxLayout.X_AXIS));

                    //======== scrollPane5 ========
                    {
                        scrollPane5.setViewportView(textArea2);
                    }
                    Custom.add(scrollPane5);
                }
                JtabbedPanel.addTab(bundle.getString("Custom.tab.title"), Custom);

                //======== DeCodeAndEnCodes ========
                {
                    DeCodeAndEnCodes.setLayout(null);

                    //======== DeAndEnCodeBase64s ========
                    {
                        DeAndEnCodeBase64s.setTabPlacement(SwingConstants.LEFT);

                        //======== Base64DeCodes ========
                        {
                            Base64DeCodes.setLayout(null);
                            Base64DeCodes.add(Base64EnsTextArea);
                            Base64EnsTextArea.setBounds(25, 40, 600, 95);

                            //---- label1 ----
                            label1.setText(bundle.getString("label1.text"));
                            Base64DeCodes.add(label1);
                            label1.setBounds(new Rectangle(new Point(25, 15), label1.getPreferredSize()));

                            //---- label2 ----
                            label2.setText(bundle.getString("label2.text"));
                            Base64DeCodes.add(label2);
                            label2.setBounds(new Rectangle(new Point(30, 150), label2.getPreferredSize()));

                            //======== scrollPane10 ========
                            {
                                scrollPane10.setViewportView(Bas64DeTextArea);
                            }
                            Base64DeCodes.add(scrollPane10);
                            scrollPane10.setBounds(25, 180, 600, 110);

                            //---- Babut1EnCode ----
                            Babut1EnCode.setText(bundle.getString("Babut1EnCode.text"));
                            Babut1EnCode.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    Babut1EnCodeMouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(Babut1EnCode);
                            Babut1EnCode.setBounds(new Rectangle(new Point(190, 145), Babut1EnCode.getPreferredSize()));

                            //---- Babut2DeCode ----
                            Babut2DeCode.setText(bundle.getString("Babut2DeCode.text"));
                            Babut2DeCode.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    Babut2DeCodeMouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(Babut2DeCode);
                            Babut2DeCode.setBounds(new Rectangle(new Point(335, 145), Babut2DeCode.getPreferredSize()));

                            //---- Base64buttonSwap ----
                            Base64buttonSwap.setText(bundle.getString("Base64buttonSwap.text"));
                            Base64buttonSwap.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    button2MouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(Base64buttonSwap);
                            Base64buttonSwap.setBounds(new Rectangle(new Point(485, 145), Base64buttonSwap.getPreferredSize()));

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < Base64DeCodes.getComponentCount(); i++) {
                                    Rectangle bounds = Base64DeCodes.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = Base64DeCodes.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                Base64DeCodes.setMinimumSize(preferredSize);
                                Base64DeCodes.setPreferredSize(preferredSize);
                            }
                        }
                        DeAndEnCodeBase64s.addTab(bundle.getString("Base64DeCodes.tab.title"), Base64DeCodes);
                    }
                    DeCodeAndEnCodes.add(DeAndEnCodeBase64s);
                    DeAndEnCodeBase64s.setBounds(0, 0, 725, 300);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < DeCodeAndEnCodes.getComponentCount(); i++) {
                            Rectangle bounds = DeCodeAndEnCodes.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = DeCodeAndEnCodes.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        DeCodeAndEnCodes.setMinimumSize(preferredSize);
                        DeCodeAndEnCodes.setPreferredSize(preferredSize);
                    }
                }
                JtabbedPanel.addTab(bundle.getString("DeCodeAndEnCodes.tab.title"), DeCodeAndEnCodes);
            }
            Panel2.add(JtabbedPanel);
            JtabbedPanel.setBounds(15, 25, 720, 335);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < Panel2.getComponentCount(); i++) {
                    Rectangle bounds = Panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = Panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                Panel2.setMinimumSize(preferredSize);
                Panel2.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(Panel2);
        Panel2.setBounds(0, 135, 750, 375);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel Panel1;
    private JPanel LPanel1;
    private JLabel LHOST;
    private JLabel LPORT;
    private JTextField LhostValue;
    private JTextField LportValue;
    private JLabel DNSLog;
    private JTextField DNSlogValue;
    private JPanel RPanel2;
    private JLabel RHOST;
    private JLabel RPORT;
    private JTextField RhostValue;
    private JTextField RportVaule;
    private JLabel Command;
    private JTextField CommandVaule;
    private JPanel Panel2;
    private JTabbedPane JtabbedPanel;
    private JTabbedPane ReverseMenu;
    private JScrollPane BashOption;
    private JTextArea BashTextArea;
    private JScrollPane JavaBashOption;
    private JTextArea JavaBashTextArea;
    private JTabbedPane msfs;
    private JScrollPane scrollPane3;
    private JTextArea msfTextArea;
    private JTabbedPane Stoways;
    private JScrollPane scrollPane2;
    private JTextArea StowayTextArea;
    private JScrollPane scrollPane4;
    private JTextArea downloadTextArea;
    private JPanel Fastjsons;
    private JTabbedPane tabbedPane1;
    private JScrollPane FaVersion;
    private JTextArea FaVersionTextArea;
    private JScrollPane FaDNSlog;
    private JTextArea FaDNSlogTextArea;
    private JScrollPane FaEXP1;
    private JTextArea FaEXP1TextArea;
    private JPanel Log4j2s;
    private JTabbedPane tabbedPane2;
    private JScrollPane scrollPane8;
    private JTextArea LoDNSlogTextArea;
    private JScrollPane scrollPane9;
    private JTextArea LoIPTextArea;
    private JPanel Custom;
    private JScrollPane scrollPane5;
    private JTextArea textArea2;
    private JPanel DeCodeAndEnCodes;
    private JTabbedPane DeAndEnCodeBase64s;
    private JPanel Base64DeCodes;
    private JTextArea Base64EnsTextArea;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane10;
    private JTextArea Bas64DeTextArea;
    private JButton Babut1EnCode;
    private JButton Babut2DeCode;
    private JButton Base64buttonSwap;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
