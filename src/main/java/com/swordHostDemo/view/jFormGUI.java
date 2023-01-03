/*
 * Created by JFormDesigner on Tue Dec 27 14:58:35 CST 2022
 */

package com.swordHostDemo.view;

import com.swordHostDemo.Controller.*;
import com.swordHostDemo.Dao.BaseDao;
import com.swordHostDemo.Dao.VaulesMenuDao;
import com.swordHostDemo.utls.CopyEchoText;
import com.swordHostDemo.utls.DeCode;
import com.swordHostDemo.utls.EnCode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;

import static com.swordHostDemo.Dao.BaseDao.executeSelectSQL;

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
        RceMenu();
        PasswordcheckBoxInit();
    }

    public void PasswordcheckBoxInit() {
        ABCcheckBox.setSelected(true);
        abcckBox.setSelected(true);
        NumcheckBox.setSelected(true);
        PasswordLens.setValue(16);
    }

    public void Appinit() {
        VaulesMenuDao vaulesMenuDao = new VaulesMenuDao();
        LhostValue.setText(executeSelectSQL(vaulesMenuDao.selectValues(), "Lhost"));
        LportValue.setText(executeSelectSQL(vaulesMenuDao.selectValues(), "Lport"));
        DNSlogValue.setText(executeSelectSQL(vaulesMenuDao.selectValues(), "DnsLog"));
        RhostValue.setText(executeSelectSQL(vaulesMenuDao.selectValues(), "Rhost"));
        RportVaule.setText(executeSelectSQL(vaulesMenuDao.selectValues(), "Rport"));
        CommandVaule.setText(executeSelectSQL(vaulesMenuDao.selectValues(), "Command"));
        FileNameVaule.setText(executeSelectSQL(vaulesMenuDao.selectValues(), "FileName"));
    }

    public void updateSQL() {
        VaulesMenuDao vaulesMenuDao = new VaulesMenuDao();
        BaseDao.executeUpdateSQL(vaulesMenuDao.updataValues(LhostValue.getText(), "Lhost"));
        BaseDao.executeUpdateSQL(vaulesMenuDao.updataValues(LportValue.getText(), "Lport"));
        BaseDao.executeUpdateSQL(vaulesMenuDao.updataValues(DNSlogValue.getText(), "DnsLog"));
        BaseDao.executeUpdateSQL(vaulesMenuDao.updataValues(RhostValue.getText(), "Rhost"));
        BaseDao.executeUpdateSQL(vaulesMenuDao.updataValues(RportVaule.getText(), "Rport"));
        BaseDao.executeUpdateSQL(vaulesMenuDao.updataValues(CommandVaule.getText(), "Command"));
        BaseDao.executeUpdateSQL(vaulesMenuDao.updataValues(FileNameVaule.getText(), "FileName"));
    }



    //Reverse
    public void ReverseMenu() {
        //BashOption
        String bash1Option = Reverse.ReverseBash1(LhostValue.getText(), LportValue.getText());
        Bash1TextArea.setText(bash1Option);

        String bash2Option = Reverse.ReverseBash2(LhostValue.getText(), LportValue.getText());
        Bash2TextArea.setText(bash2Option);

        //JavaBashOption
        String javaBashOption = EnCode.JavaEncode(LhostValue.getText(), LportValue.getText());
        JavaBashTextArea.setText(javaBashOption);


    }

    public void msfShellMenu() {
        String getLhost =LhostValue.getText();
        String getLport =LportValue.getText();
        String getFileName =FileNameVaule.getText();
        //msf init
        String payload = "exploit/linux/local/cve_2021_4034_pwnkit_lpe_pkexec";
        String rootCommand = Metasploit.RootCommand(payload, "", "", "");
        msfRootTextArea.setText(rootCommand);

        //msf linuxPayload
        String MsflinuxHex = Metasploit.MsflinuxHexCommand(getLhost, getLport);
        msfLinuxHexTextField.setText(MsflinuxHex);

        //MSF linuxElfPayload
        String msflinuxELFCommand = Metasploit.MsflinuxELFCommand(getLhost,getLport, getFileName);
        msfLinuxELFTextField.setText(msflinuxELFCommand);

        //msf LinuxListener
        String msfLinuxListener = Metasploit.ListenerLinuxhandler(getLhost,getLport);
        msfLinuxListenerTextArea.setText(msfLinuxListener);

        //msf WindowsListener
        String msfWindowsListener = Metasploit.ListenerWindowshandler(getLhost,getLport);
        msfWindowsListenerTextArea.setText(msfWindowsListener);

    }

    public void StowawayMenu() {
       //admin
        String stowawayAdmin = StowawayController.StowawayAdmin(LportValue.getText(),"243141");
        stAdminTextArea.setText(stowawayAdmin);
        //linux agent
        String stowawayLinuxAgent = StowawayController.StowawayLinuxAgent(LhostValue.getText(),LportValue.getText(),"243141",FileNameVaule.getText());
        stLinuxAgentTextArea.setText(stowawayLinuxAgent);
        //windows agent
        String stowawayWindowsAgent = StowawayController.StowawayWindosAgent(LhostValue.getText(),LportValue.getText(),"243141");
        stWindowsAgentTextArea.setText(stowawayWindowsAgent);
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

    public void RceMenu() {
        //Curl
        String Curl1Options = RCECommand.Curl1Command(LhostValue.getText(), LportValue.getText(), FileNameVaule.getText());
        Curl1TextField.setText(Curl1Options);
        //Curl
        String Curl2Options = RCECommand.Curl2Command(LhostValue.getText(), LportValue.getText(), FileNameVaule.getText());
        Curl2TextField.setText(Curl2Options);

        //wget
        String WgetOptions = RCECommand.Wget1Command(LhostValue.getText(), LportValue.getText(), FileNameVaule.getText());
        Wget1TextArea.setText(WgetOptions);

        //Python
        String PythonOptions = RCECommand.pythonCommand(LhostValue.getText(), LportValue.getText(), FileNameVaule.getText());
        PythonTextArea.setText(PythonOptions);


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
        init();

    }

    //FielName
    private void FileNameVauleKeyReleased(KeyEvent e) {
        // TODO add your code here
        String fileNameVaule = FileNameVaule.getText();
        System.out.println(fileNameVaule);
        init();
    }

    //base64按钮实现
    private void Babut2DeCodeMouseClicked(MouseEvent e) {
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

    //交换按钮功能实现
    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        //交换按钮功能实现
        String a = Base64EnsTextArea.getText();
        String b = Bas64DeTextArea.getText();
        String t = a;
        Base64EnsTextArea.setText(t);
        a = b;
        Base64EnsTextArea.setText(a);
        b = t;
        Bas64DeTextArea.setText(b);
    }

    //窗口启动做的事情
    private void thisWindowOpened(WindowEvent e) {
        // TODO add your code here
        Appinit();
        init();

    }


    //password随机按钮点击
    private void RandomButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        int value = (int) PasswordLens.getValue();
        for (int i = 0; i < 4; ) {
            RandomTextField.setText(RandomValue.RandomComplexPassword(RandomComplexpass(), value));
            i++;
        }
        System.out.println(RandomComplexpass());
    }

    //password判断生成
    public String RandomComplexpass() {

        String ABCstr = "ABCDEFGHIJKLMNPQRSTUVWXYZ";
        String abcstr = "abcdefghjkmnopqrstuvwxyz";
        String numstr = "123456789";
        String Singstr = "!@#$%^&*()_+";

        if (!ABCcheckBox.isSelected()) {
            ABCstr = "";
        }
        if (!abcckBox.isSelected()) {
            abcstr = "";
        }
        if (!NumcheckBox.isSelected()) {
            numstr = "";
        }
        if (!SigncheckBox.isSelected()) {
            Singstr = "";
        }
        String ALLstr = ABCstr + abcstr + numstr + Singstr;
        System.out.println(ALLstr);
        return ALLstr;
    }
    private void IPCopybuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REip);
        CopyEcholabel.setText("复制IP正则表达式成功\r\n内容为："+RE.REip);
    }
    private void URLCopybuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REurl);
        CopyEcholabel.setText("复制URL正则表达式成功\r\n内容为："+RE.REurl);
    }

    private void URLPathbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REurlPath);
        CopyEcholabel.setText("复制URL+Path正则表达式成功\r\n内容为："+RE.REurlPath);
    }

    private void URLPortbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REurlPort);
        CopyEcholabel.setText("复制URL+port正则表达式成功\r\n内容为："+RE.REurlPort);
    }

    private void AliyunaAccessKeyMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REAliyunAccessKey);
        CopyEcholabel.setText("复制AliyunAccessKey正则表达式成功\r\n内容为："+RE.REAliyunAccessKey);
    }

    private void AliyunSecretKeyMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REAliyunSecretKey);
        CopyEcholabel.setText("复制AliyunSecretKey正则表达式成功\r\n内容为："+RE.REAliyunSecretKey);
    }

    private void AliyunOssUrlMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REAliyunOssUrl);
        CopyEcholabel.setText("复制AliyunOssUrl正则表达式成功\r\n内容为："+RE.REAliyunOssUrl);
    }

    private void AWSAccessKeyIdMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REAWS_AccessKeyId);
        CopyEcholabel.setText("复制AWS_AccessKeyId正则表达式成功\r\n内容为："+RE.REAWS_AccessKeyId);
    }

    private void AWSAuthTokenMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REAWS_AuthToken);
        CopyEcholabel.setText("复制AWS_AuthToken正则表达式成功\r\n内容为："+RE.REAWS_AuthToken);
    }

    private void AWSURLMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.REAWS_url);
        CopyEcholabel.setText("复制AWS_url正则表达式成功\r\n内容为："+RE.REAWS_url);
    }


    private void SSHkeyMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.RESSH_key);
        CopyEcholabel.setText("复制SSH_key正则表达式成功\r\n内容为："+RE.RESSH_key);
    }

    private void RSAKEYbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RE.RErsa_key);
        CopyEcholabel.setText("复制rsa_key正则表达式成功\r\n内容为："+RE.RErsa_key);
    }

    private void CopyPasswordbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(RandomTextField.getText());
    }

    private void stCopyIpSocksButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        String SocksText = stSocksTextField.getText();
        CopyEchoText.init(LhostValue.getText()+":"+SocksText);
    }

    private void msfCopyRootButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(msfRootTextField.getText());
    }

    private void msfCopyRootButton2MouseClicked(MouseEvent e) {
        // TODO add your code here
        String rootCommand = Metasploit.RootCommand(msfPayloadCopyTextField.getText(),LhostValue.getText(), LportValue.getText(), sessionIdTextField.getText());
        CopyEchoText.init(rootCommand);
        msfRootTextArea.setText(rootCommand);
    }

    private void FaCopyEXP1TextAreaMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(FaEXP1TextArea.getText());
        FaCopyEcholabel.setText("复制成功~");
    }

    private void BaCopyResButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        CopyEchoText.init(Bas64DeTextArea.getText());
        BaCopyEcholabel.setText("复制成功~");

    }


    private void thisWindowClosing(WindowEvent e) {
        // TODO add your code here
        updateSQL();
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
        FileName = new JLabel();
        FileNameVaule = new JTextField();
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
        Bash1TextArea = new JTextArea();
        scrollPane1 = new JScrollPane();
        Bash2TextArea = new JTextArea();
        JavaBashOption = new JScrollPane();
        JavaBashTextArea = new JTextArea();
        RCEMenu = new JPanel();
        CurlOption = new JTabbedPane();
        panel3 = new JPanel();
        label6 = new JLabel();
        Curl2TextField = new JTextField();
        label8 = new JLabel();
        Curl1TextField = new JTextField();
        label7 = new JLabel();
        label9 = new JLabel();
        WgetOption = new JPanel();
        scrollPane7 = new JScrollPane();
        Wget1TextArea = new JTextArea();
        PythonOption = new JPanel();
        scrollPane12 = new JScrollPane();
        PythonTextArea = new JTextArea();
        msfs = new JTabbedPane();
        LinuxPayloadOptions = new JPanel();
        label33 = new JLabel();
        msfLinuxHexTextField = new JTextField();
        label34 = new JLabel();
        msfLinuxELFTextField = new JTextField();
        msfListenerOptions = new JPanel();
        label36 = new JLabel();
        label37 = new JLabel();
        scrollPane16 = new JScrollPane();
        msfLinuxListenerTextArea = new JTextArea();
        scrollPane17 = new JScrollPane();
        msfWindowsListenerTextArea = new JTextArea();
        msfRootOptions = new JPanel();
        msfRootTextField = new JTextField();
        label28 = new JLabel();
        msfCopyRootButton = new JButton();
        label29 = new JLabel();
        msfCopyRootButton2 = new JButton();
        label31 = new JLabel();
        sessionIdTextField = new JTextField();
        scrollPane15 = new JScrollPane();
        msfRootTextArea = new JTextArea();
        msfPayloadCopyTextField = new JTextField();
        label32 = new JLabel();
        Stoways = new JTabbedPane();
        AdminOptions = new JPanel();
        label5 = new JLabel();
        scrollPane4 = new JScrollPane();
        stAdminTextArea = new JTextArea();
        label19 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        stSocksTextField = new JTextField();
        stCopyIpSocksButton = new JButton();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        label27 = new JLabel();
        AgentOptions = new JPanel();
        label17 = new JLabel();
        label18 = new JLabel();
        scrollPane13 = new JScrollPane();
        stLinuxAgentTextArea = new JTextArea();
        scrollPane14 = new JScrollPane();
        stWindowsAgentTextArea = new JTextArea();
        JavaMenu = new JPanel();
        tabbedPane4 = new JTabbedPane();
        FastjsonOptions = new JPanel();
        label38 = new JLabel();
        textField5 = new JTextField();
        label39 = new JLabel();
        scrollPane18 = new JScrollPane();
        FaDNSlogTextArea = new JTextArea();
        FaEXP1Options = new JPanel();
        FaEXP1 = new JScrollPane();
        FaEXP1TextArea = new JTextArea();
        FaCopyEXP1TextArea = new JButton();
        FaCopyEcholabel = new JLabel();
        Log4j2Options = new JPanel();
        label40 = new JLabel();
        LoIPTextArea = new JTextField();
        label41 = new JLabel();
        LoDNSlogTextArea = new JTextField();
        REs = new JPanel();
        tabbedPane3 = new JTabbedPane();
        panel9 = new JPanel();
        label11 = new JLabel();
        label12 = new JLabel();
        IPCopybutton = new JButton();
        CopyEcholabel = new JLabel();
        URLCopybutton = new JButton();
        URLPathbutton = new JButton();
        URLPortbutton = new JButton();
        AliyunaAccessKey = new JButton();
        label10 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        AliyunSecretKey = new JButton();
        AliyunOssUrl = new JButton();
        label15 = new JLabel();
        AWSAccessKeyId = new JButton();
        AWSAuthToken = new JButton();
        AWSURL = new JButton();
        label16 = new JLabel();
        SSHkey = new JButton();
        RSAKEYbutton = new JButton();
        DeCodeAndEnCodes = new JPanel();
        DeAndEnCodeBase64s = new JTabbedPane();
        Base64DeCodes = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane10 = new JScrollPane();
        Bas64DeTextArea = new JTextArea();
        Babut1EnCode = new JButton();
        Babut2DeCode = new JButton();
        Base64buttonSwap = new JButton();
        scrollPane11 = new JScrollPane();
        Base64EnsTextArea = new JTextArea();
        BaCopyResButton = new JButton();
        BaCopyEcholabel = new JLabel();
        RandomMenu = new JPanel();
        scrollPane6 = new JScrollPane();
        tabbedPane5 = new JTabbedPane();
        panel2 = new JPanel();
        RandomButton = new JButton();
        RandomTextField = new JTextField();
        ABCcheckBox = new JCheckBox();
        abcckBox = new JCheckBox();
        NumcheckBox = new JCheckBox();
        SigncheckBox = new JCheckBox();
        PasswordLens = new JSpinner();
        label4 = new JLabel();
        CopyPasswordbutton = new JButton();
        Custom = new JPanel();
        scrollPane5 = new JScrollPane();
        CustomEditOptions = new JTabbedPane();
        CustomSaveJp = new JPanel();
        label42 = new JLabel();
        CustomEdit1IOptions = new JScrollPane();
        CustomEdit1TextArea = new JTextArea();
        label3 = new JLabel();

        //======== this ========
        setTitle(bundle.getString("this.title"));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
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
                LHOST.setBounds(10, 10, 55, LHOST.getPreferredSize().height);

                //---- LPORT ----
                LPORT.setText("LPORT");
                LPanel1.add(LPORT);
                LPORT.setBounds(200, 10, 55, LPORT.getPreferredSize().height);

                //---- LhostValue ----
                LhostValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        LhostValueKeyReleased(e);
                    }
                });
                LPanel1.add(LhostValue);
                LhostValue.setBounds(65, 5, 115, LhostValue.getPreferredSize().height);

                //---- LportValue ----
                LportValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        LportValueKeyReleased(e);
                    }
                });
                LPanel1.add(LportValue);
                LportValue.setBounds(250, 5, 55, LportValue.getPreferredSize().height);

                //---- DNSLog ----
                DNSLog.setText("DNSLog");
                LPanel1.add(DNSLog);
                DNSLog.setBounds(335, 10, 65, DNSLog.getPreferredSize().height);

                //---- DNSlogValue ----
                DNSlogValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        DNSlogValueKeyReleased(e);
                    }
                });
                LPanel1.add(DNSlogValue);
                DNSlogValue.setBounds(410, 5, 110, DNSlogValue.getPreferredSize().height);

                //---- FileName ----
                FileName.setText("File name");
                LPanel1.add(FileName);
                FileName.setBounds(540, 10, 70, 17);

                //---- FileNameVaule ----
                FileNameVaule.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        FileNameVauleKeyReleased(e);
                    }
                });
                LPanel1.add(FileNameVaule);
                FileNameVaule.setBounds(605, 5, 110, 30);

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
            LPanel1.setBounds(10, 15, 755, 45);

            //======== RPanel2 ========
            {
                RPanel2.setLayout(null);

                //---- RHOST ----
                RHOST.setText(bundle.getString("RHOST.text"));
                RPanel2.add(RHOST);
                RHOST.setBounds(10, 10, 55, RHOST.getPreferredSize().height);

                //---- RPORT ----
                RPORT.setText("RPORT");
                RPanel2.add(RPORT);
                RPORT.setBounds(200, 10, 55, RPORT.getPreferredSize().height);

                //---- RhostValue ----
                RhostValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        RhostValueKeyReleased(e);
                    }
                });
                RPanel2.add(RhostValue);
                RhostValue.setBounds(65, 5, 115, RhostValue.getPreferredSize().height);

                //---- RportVaule ----
                RportVaule.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        RportVauleKeyReleased(e);
                    }
                });
                RPanel2.add(RportVaule);
                RportVaule.setBounds(250, 5, 55, RportVaule.getPreferredSize().height);

                //---- Command ----
                Command.setText("Command");
                RPanel2.add(Command);
                Command.setBounds(335, 10, 70, Command.getPreferredSize().height);

                //---- CommandVaule ----
                CommandVaule.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        CommandVauleKeyReleased(e);
                    }
                });
                RPanel2.add(CommandVaule);
                CommandVaule.setBounds(410, 5, 110, CommandVaule.getPreferredSize().height);

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
            RPanel2.setBounds(10, 65, 760, 45);

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
        Panel1.setBounds(5, 15, 780, 120);

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
                        BashOption.setViewportView(Bash1TextArea);
                    }
                    ReverseMenu.addTab("Bash 1", BashOption);

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(Bash2TextArea);
                    }
                    ReverseMenu.addTab("Bash 2", scrollPane1);

                    //======== JavaBashOption ========
                    {
                        JavaBashOption.setViewportView(JavaBashTextArea);
                    }
                    ReverseMenu.addTab("JavaBash", JavaBashOption);
                }
                JtabbedPanel.addTab(bundle.getString("ReverseMenu.tab.title"), ReverseMenu);

                //======== RCEMenu ========
                {
                    RCEMenu.setLayout(null);

                    //======== CurlOption ========
                    {
                        CurlOption.setTabPlacement(SwingConstants.LEFT);

                        //======== panel3 ========
                        {
                            panel3.setLayout(null);

                            //---- label6 ----
                            label6.setText(bundle.getString("label6.text"));
                            panel3.add(label6);
                            label6.setBounds(new Rectangle(new Point(20, 35), label6.getPreferredSize()));
                            panel3.add(Curl2TextField);
                            Curl2TextField.setBounds(20, 150, 645, 30);

                            //---- label8 ----
                            label8.setText(bundle.getString("label8.text"));
                            panel3.add(label8);
                            label8.setBounds(20, 125, 43, 17);
                            panel3.add(Curl1TextField);
                            Curl1TextField.setBounds(20, 85, 645, 30);

                            //---- label7 ----
                            label7.setText(bundle.getString("label7.text"));
                            panel3.add(label7);
                            label7.setBounds(20, 60, 43, 17);

                            //---- label9 ----
                            label9.setText(bundle.getString("label9.text"));
                            panel3.add(label9);
                            label9.setBounds(20, 5, 105, 30);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel3.getComponentCount(); i++) {
                                    Rectangle bounds = panel3.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel3.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel3.setMinimumSize(preferredSize);
                                panel3.setPreferredSize(preferredSize);
                            }
                        }
                        CurlOption.addTab(bundle.getString("panel3.tab.title"), panel3);

                        //======== WgetOption ========
                        {
                            WgetOption.setLayout(null);

                            //======== scrollPane7 ========
                            {
                                scrollPane7.setViewportView(Wget1TextArea);
                            }
                            WgetOption.add(scrollPane7);
                            scrollPane7.setBounds(20, 25, 655, 130);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < WgetOption.getComponentCount(); i++) {
                                    Rectangle bounds = WgetOption.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = WgetOption.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                WgetOption.setMinimumSize(preferredSize);
                                WgetOption.setPreferredSize(preferredSize);
                            }
                        }
                        CurlOption.addTab(bundle.getString("WgetOption.tab.title"), WgetOption);

                        //======== PythonOption ========
                        {
                            PythonOption.setLayout(null);

                            //======== scrollPane12 ========
                            {
                                scrollPane12.setViewportView(PythonTextArea);
                            }
                            PythonOption.add(scrollPane12);
                            scrollPane12.setBounds(15, 30, 645, 145);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < PythonOption.getComponentCount(); i++) {
                                    Rectangle bounds = PythonOption.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = PythonOption.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                PythonOption.setMinimumSize(preferredSize);
                                PythonOption.setPreferredSize(preferredSize);
                            }
                        }
                        CurlOption.addTab(bundle.getString("PythonOption.tab.title"), PythonOption);
                    }
                    RCEMenu.add(CurlOption);
                    CurlOption.setBounds(0, 0, 760, 335);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < RCEMenu.getComponentCount(); i++) {
                            Rectangle bounds = RCEMenu.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = RCEMenu.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        RCEMenu.setMinimumSize(preferredSize);
                        RCEMenu.setPreferredSize(preferredSize);
                    }
                }
                JtabbedPanel.addTab(bundle.getString("RCEMenu.tab.title"), RCEMenu);

                //======== msfs ========
                {
                    msfs.setTabPlacement(SwingConstants.LEFT);

                    //======== LinuxPayloadOptions ========
                    {
                        LinuxPayloadOptions.setLayout(null);

                        //---- label33 ----
                        label33.setText(bundle.getString("label33.text"));
                        LinuxPayloadOptions.add(label33);
                        label33.setBounds(new Rectangle(new Point(25, 25), label33.getPreferredSize()));
                        LinuxPayloadOptions.add(msfLinuxHexTextField);
                        msfLinuxHexTextField.setBounds(20, 50, 625, msfLinuxHexTextField.getPreferredSize().height);

                        //---- label34 ----
                        label34.setText(bundle.getString("label34.text"));
                        LinuxPayloadOptions.add(label34);
                        label34.setBounds(new Rectangle(new Point(25, 95), label34.getPreferredSize()));
                        LinuxPayloadOptions.add(msfLinuxELFTextField);
                        msfLinuxELFTextField.setBounds(20, 125, 625, msfLinuxELFTextField.getPreferredSize().height);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < LinuxPayloadOptions.getComponentCount(); i++) {
                                Rectangle bounds = LinuxPayloadOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = LinuxPayloadOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            LinuxPayloadOptions.setMinimumSize(preferredSize);
                            LinuxPayloadOptions.setPreferredSize(preferredSize);
                        }
                    }
                    msfs.addTab(bundle.getString("LinuxPayloadOptions.tab.title"), LinuxPayloadOptions);

                    //======== msfListenerOptions ========
                    {
                        msfListenerOptions.setLayout(null);

                        //---- label36 ----
                        label36.setText(bundle.getString("label36.text"));
                        msfListenerOptions.add(label36);
                        label36.setBounds(new Rectangle(new Point(30, 20), label36.getPreferredSize()));

                        //---- label37 ----
                        label37.setText(bundle.getString("label37.text"));
                        msfListenerOptions.add(label37);
                        label37.setBounds(new Rectangle(new Point(30, 175), label37.getPreferredSize()));

                        //======== scrollPane16 ========
                        {
                            scrollPane16.setViewportView(msfLinuxListenerTextArea);
                        }
                        msfListenerOptions.add(scrollPane16);
                        scrollPane16.setBounds(25, 45, 610, 110);

                        //======== scrollPane17 ========
                        {
                            scrollPane17.setViewportView(msfWindowsListenerTextArea);
                        }
                        msfListenerOptions.add(scrollPane17);
                        scrollPane17.setBounds(25, 205, 610, 105);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < msfListenerOptions.getComponentCount(); i++) {
                                Rectangle bounds = msfListenerOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = msfListenerOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            msfListenerOptions.setMinimumSize(preferredSize);
                            msfListenerOptions.setPreferredSize(preferredSize);
                        }
                    }
                    msfs.addTab(bundle.getString("msfListenerOptions.tab.title"), msfListenerOptions);

                    //======== msfRootOptions ========
                    {
                        msfRootOptions.setLayout(null);

                        //---- msfRootTextField ----
                        msfRootTextField.setText(bundle.getString("msfRootTextField.text"));
                        msfRootOptions.add(msfRootTextField);
                        msfRootTextField.setBounds(25, 35, 300, msfRootTextField.getPreferredSize().height);

                        //---- label28 ----
                        label28.setText(bundle.getString("label28.text"));
                        msfRootOptions.add(label28);
                        label28.setBounds(new Rectangle(new Point(30, 10), label28.getPreferredSize()));

                        //---- msfCopyRootButton ----
                        msfCopyRootButton.setText(bundle.getString("msfCopyRootButton.text"));
                        msfCopyRootButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                msfCopyRootButtonMouseClicked(e);
                            }
                        });
                        msfRootOptions.add(msfCopyRootButton);
                        msfCopyRootButton.setBounds(new Rectangle(new Point(340, 35), msfCopyRootButton.getPreferredSize()));

                        //---- label29 ----
                        label29.setText(bundle.getString("label29.text"));
                        msfRootOptions.add(label29);
                        label29.setBounds(new Rectangle(new Point(30, 85), label29.getPreferredSize()));

                        //---- msfCopyRootButton2 ----
                        msfCopyRootButton2.setText(bundle.getString("msfCopyRootButton2.text"));
                        msfCopyRootButton2.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                msfCopyRootButton2MouseClicked(e);
                            }
                        });
                        msfRootOptions.add(msfCopyRootButton2);
                        msfCopyRootButton2.setBounds(new Rectangle(new Point(505, 285), msfCopyRootButton2.getPreferredSize()));

                        //---- label31 ----
                        label31.setText(bundle.getString("label31.text"));
                        msfRootOptions.add(label31);
                        label31.setBounds(new Rectangle(new Point(25, 150), label31.getPreferredSize()));
                        msfRootOptions.add(sessionIdTextField);
                        sessionIdTextField.setBounds(new Rectangle(new Point(90, 145), sessionIdTextField.getPreferredSize()));

                        //======== scrollPane15 ========
                        {
                            scrollPane15.setViewportView(msfRootTextArea);
                        }
                        msfRootOptions.add(scrollPane15);
                        scrollPane15.setBounds(20, 200, 445, 155);

                        //---- msfPayloadCopyTextField ----
                        msfPayloadCopyTextField.setText(bundle.getString("msfPayloadCopyTextField.text"));
                        msfRootOptions.add(msfPayloadCopyTextField);
                        msfPayloadCopyTextField.setBounds(90, 110, 370, msfPayloadCopyTextField.getPreferredSize().height);

                        //---- label32 ----
                        label32.setText(bundle.getString("label32.text"));
                        msfRootOptions.add(label32);
                        label32.setBounds(new Rectangle(new Point(25, 115), label32.getPreferredSize()));

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < msfRootOptions.getComponentCount(); i++) {
                                Rectangle bounds = msfRootOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = msfRootOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            msfRootOptions.setMinimumSize(preferredSize);
                            msfRootOptions.setPreferredSize(preferredSize);
                        }
                    }
                    msfs.addTab(bundle.getString("msfRootOptions.tab.title"), msfRootOptions);
                }
                JtabbedPanel.addTab(bundle.getString("msfs.tab.title"), msfs);

                //======== Stoways ========
                {
                    Stoways.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                    Stoways.setTabPlacement(SwingConstants.LEFT);

                    //======== AdminOptions ========
                    {
                        AdminOptions.setLayout(null);

                        //---- label5 ----
                        label5.setText(bundle.getString("label5.text"));
                        AdminOptions.add(label5);
                        label5.setBounds(new Rectangle(new Point(25, 10), label5.getPreferredSize()));

                        //======== scrollPane4 ========
                        {
                            scrollPane4.setViewportView(stAdminTextArea);
                        }
                        AdminOptions.add(scrollPane4);
                        scrollPane4.setBounds(20, 35, 650, 105);

                        //---- label19 ----
                        label19.setText(bundle.getString("label19.text"));
                        AdminOptions.add(label19);
                        label19.setBounds(new Rectangle(new Point(20, 165), label19.getPreferredSize()));

                        //---- label20 ----
                        label20.setText(bundle.getString("label20.text"));
                        AdminOptions.add(label20);
                        label20.setBounds(new Rectangle(new Point(20, 190), label20.getPreferredSize()));
                        AdminOptions.add(label21);
                        label21.setBounds(new Rectangle(new Point(555, 85), label21.getPreferredSize()));

                        //---- stSocksTextField ----
                        stSocksTextField.setText(bundle.getString("stSocksTextField.text"));
                        AdminOptions.add(stSocksTextField);
                        stSocksTextField.setBounds(60, 210, 75, stSocksTextField.getPreferredSize().height);

                        //---- stCopyIpSocksButton ----
                        stCopyIpSocksButton.setText(bundle.getString("stCopyIpSocksButton.text"));
                        stCopyIpSocksButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                stCopyIpSocksButtonMouseClicked(e);
                            }
                        });
                        AdminOptions.add(stCopyIpSocksButton);
                        stCopyIpSocksButton.setBounds(new Rectangle(new Point(150, 210), stCopyIpSocksButton.getPreferredSize()));

                        //---- label22 ----
                        label22.setText(bundle.getString("label22.text"));
                        AdminOptions.add(label22);
                        label22.setBounds(new Rectangle(new Point(20, 215), label22.getPreferredSize()));
                        AdminOptions.add(label23);
                        label23.setBounds(new Rectangle(new Point(550, 115), label23.getPreferredSize()));

                        //---- label24 ----
                        label24.setText(bundle.getString("label24.text"));
                        AdminOptions.add(label24);
                        label24.setBounds(20, 300, label24.getPreferredSize().width, 17);

                        //---- label25 ----
                        label25.setText(bundle.getString("label25.text"));
                        AdminOptions.add(label25);
                        label25.setBounds(new Rectangle(new Point(20, 275), label25.getPreferredSize()));

                        //---- label26 ----
                        label26.setText(bundle.getString("label26.text"));
                        AdminOptions.add(label26);
                        label26.setBounds(new Rectangle(new Point(20, 145), label26.getPreferredSize()));

                        //---- label27 ----
                        label27.setText(bundle.getString("label27.text"));
                        AdminOptions.add(label27);
                        label27.setBounds(new Rectangle(new Point(20, 250), label27.getPreferredSize()));

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < AdminOptions.getComponentCount(); i++) {
                                Rectangle bounds = AdminOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = AdminOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            AdminOptions.setMinimumSize(preferredSize);
                            AdminOptions.setPreferredSize(preferredSize);
                        }
                    }
                    Stoways.addTab(bundle.getString("AdminOptions.tab.title"), AdminOptions);

                    //======== AgentOptions ========
                    {
                        AgentOptions.setLayout(null);

                        //---- label17 ----
                        label17.setText(bundle.getString("label17.text"));
                        AgentOptions.add(label17);
                        label17.setBounds(20, 15, 150, 17);

                        //---- label18 ----
                        label18.setText(bundle.getString("label18.text"));
                        AgentOptions.add(label18);
                        label18.setBounds(20, 160, 150, 17);

                        //======== scrollPane13 ========
                        {
                            scrollPane13.setViewportView(stLinuxAgentTextArea);
                        }
                        AgentOptions.add(scrollPane13);
                        scrollPane13.setBounds(20, 45, 645, 85);

                        //======== scrollPane14 ========
                        {
                            scrollPane14.setViewportView(stWindowsAgentTextArea);
                        }
                        AgentOptions.add(scrollPane14);
                        scrollPane14.setBounds(20, 195, 645, 80);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < AgentOptions.getComponentCount(); i++) {
                                Rectangle bounds = AgentOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = AgentOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            AgentOptions.setMinimumSize(preferredSize);
                            AgentOptions.setPreferredSize(preferredSize);
                        }
                    }
                    Stoways.addTab(bundle.getString("AgentOptions.tab.title"), AgentOptions);
                }
                JtabbedPanel.addTab(bundle.getString("Stoways.tab.title"), Stoways);

                //======== JavaMenu ========
                {
                    JavaMenu.setLayout(null);

                    //======== tabbedPane4 ========
                    {
                        tabbedPane4.setTabPlacement(SwingConstants.LEFT);

                        //======== FastjsonOptions ========
                        {
                            FastjsonOptions.setLayout(null);

                            //---- label38 ----
                            label38.setText(bundle.getString("label38.text"));
                            FastjsonOptions.add(label38);
                            label38.setBounds(new Rectangle(new Point(25, 20), label38.getPreferredSize()));

                            //---- textField5 ----
                            textField5.setText(bundle.getString("textField5.text"));
                            FastjsonOptions.add(textField5);
                            textField5.setBounds(20, 45, 480, textField5.getPreferredSize().height);

                            //---- label39 ----
                            label39.setText(bundle.getString("label39.text"));
                            FastjsonOptions.add(label39);
                            label39.setBounds(new Rectangle(new Point(25, 90), label39.getPreferredSize()));

                            //======== scrollPane18 ========
                            {
                                scrollPane18.setViewportView(FaDNSlogTextArea);
                            }
                            FastjsonOptions.add(scrollPane18);
                            scrollPane18.setBounds(25, 125, 475, 90);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < FastjsonOptions.getComponentCount(); i++) {
                                    Rectangle bounds = FastjsonOptions.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = FastjsonOptions.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                FastjsonOptions.setMinimumSize(preferredSize);
                                FastjsonOptions.setPreferredSize(preferredSize);
                            }
                        }
                        tabbedPane4.addTab(bundle.getString("FastjsonOptions.tab.title"), FastjsonOptions);

                        //======== FaEXP1Options ========
                        {
                            FaEXP1Options.setLayout(null);

                            //======== FaEXP1 ========
                            {
                                FaEXP1.setViewportView(FaEXP1TextArea);
                            }
                            FaEXP1Options.add(FaEXP1);
                            FaEXP1.setBounds(10, 10, 620, 265);

                            //---- FaCopyEXP1TextArea ----
                            FaCopyEXP1TextArea.setText(bundle.getString("FaCopyEXP1TextArea.text"));
                            FaCopyEXP1TextArea.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    FaCopyEXP1TextAreaMouseClicked(e);
                                }
                            });
                            FaEXP1Options.add(FaCopyEXP1TextArea);
                            FaCopyEXP1TextArea.setBounds(new Rectangle(new Point(15, 305), FaCopyEXP1TextArea.getPreferredSize()));
                            FaEXP1Options.add(FaCopyEcholabel);
                            FaCopyEcholabel.setBounds(170, 305, 255, 25);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < FaEXP1Options.getComponentCount(); i++) {
                                    Rectangle bounds = FaEXP1Options.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = FaEXP1Options.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                FaEXP1Options.setMinimumSize(preferredSize);
                                FaEXP1Options.setPreferredSize(preferredSize);
                            }
                        }
                        tabbedPane4.addTab(bundle.getString("FaEXP1Options.tab.title"), FaEXP1Options);

                        //======== Log4j2Options ========
                        {
                            Log4j2Options.setLayout(null);

                            //---- label40 ----
                            label40.setText(bundle.getString("label40.text"));
                            Log4j2Options.add(label40);
                            label40.setBounds(new Rectangle(new Point(25, 25), label40.getPreferredSize()));
                            Log4j2Options.add(LoIPTextArea);
                            LoIPTextArea.setBounds(25, 55, 510, LoIPTextArea.getPreferredSize().height);

                            //---- label41 ----
                            label41.setText(bundle.getString("label41.text"));
                            Log4j2Options.add(label41);
                            label41.setBounds(new Rectangle(new Point(25, 95), label41.getPreferredSize()));
                            Log4j2Options.add(LoDNSlogTextArea);
                            LoDNSlogTextArea.setBounds(25, 130, 510, LoDNSlogTextArea.getPreferredSize().height);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < Log4j2Options.getComponentCount(); i++) {
                                    Rectangle bounds = Log4j2Options.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = Log4j2Options.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                Log4j2Options.setMinimumSize(preferredSize);
                                Log4j2Options.setPreferredSize(preferredSize);
                            }
                        }
                        tabbedPane4.addTab(bundle.getString("Log4j2Options.tab.title"), Log4j2Options);
                    }
                    JavaMenu.add(tabbedPane4);
                    tabbedPane4.setBounds(0, 0, 750, 380);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < JavaMenu.getComponentCount(); i++) {
                            Rectangle bounds = JavaMenu.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = JavaMenu.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        JavaMenu.setMinimumSize(preferredSize);
                        JavaMenu.setPreferredSize(preferredSize);
                    }
                }
                JtabbedPanel.addTab(bundle.getString("JavaMenu.tab.title"), JavaMenu);

                //======== REs ========
                {
                    REs.setLayout(null);

                    //======== tabbedPane3 ========
                    {
                        tabbedPane3.setTabPlacement(SwingConstants.LEFT);

                        //======== panel9 ========
                        {
                            panel9.setLayout(null);
                            panel9.add(label11);
                            label11.setBounds(new Rectangle(new Point(25, 40), label11.getPreferredSize()));
                            panel9.add(label12);
                            label12.setBounds(new Rectangle(new Point(15, 65), label12.getPreferredSize()));

                            //---- IPCopybutton ----
                            IPCopybutton.setText(bundle.getString("IPCopybutton.text"));
                            IPCopybutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    IPCopybuttonMouseClicked(e);
                                }
                            });
                            panel9.add(IPCopybutton);
                            IPCopybutton.setBounds(new Rectangle(new Point(15, 35), IPCopybutton.getPreferredSize()));

                            //---- CopyEcholabel ----
                            CopyEcholabel.setAutoscrolls(true);
                            panel9.add(CopyEcholabel);
                            CopyEcholabel.setBounds(20, 285, 630, 45);

                            //---- URLCopybutton ----
                            URLCopybutton.setText(bundle.getString("URLCopybutton.text"));
                            URLCopybutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    URLCopybuttonMouseClicked(e);
                                }
                            });
                            panel9.add(URLCopybutton);
                            URLCopybutton.setBounds(new Rectangle(new Point(115, 35), URLCopybutton.getPreferredSize()));

                            //---- URLPathbutton ----
                            URLPathbutton.setText(bundle.getString("URLPathbutton.text"));
                            URLPathbutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    URLPathbuttonMouseClicked(e);
                                }
                            });
                            panel9.add(URLPathbutton);
                            URLPathbutton.setBounds(new Rectangle(new Point(240, 35), URLPathbutton.getPreferredSize()));

                            //---- URLPortbutton ----
                            URLPortbutton.setText(bundle.getString("URLPortbutton.text"));
                            URLPortbutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    URLPortbuttonMouseClicked(e);
                                }
                            });
                            panel9.add(URLPortbutton);
                            URLPortbutton.setBounds(new Rectangle(new Point(350, 35), URLPortbutton.getPreferredSize()));

                            //---- AliyunaAccessKey ----
                            AliyunaAccessKey.setText(bundle.getString("AliyunaAccessKey.text"));
                            AliyunaAccessKey.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AliyunaAccessKeyMouseClicked(e);
                                }
                            });
                            panel9.add(AliyunaAccessKey);
                            AliyunaAccessKey.setBounds(new Rectangle(new Point(15, 90), AliyunaAccessKey.getPreferredSize()));

                            //---- label10 ----
                            label10.setText(bundle.getString("label10.text"));
                            panel9.add(label10);
                            label10.setBounds(new Rectangle(new Point(20, 10), label10.getPreferredSize()));

                            //---- label13 ----
                            label13.setText(bundle.getString("label13.text"));
                            panel9.add(label13);
                            label13.setBounds(new Rectangle(new Point(120, 10), label13.getPreferredSize()));

                            //---- label14 ----
                            label14.setText(bundle.getString("label14.text"));
                            panel9.add(label14);
                            label14.setBounds(20, 70, 59, 17);

                            //---- AliyunSecretKey ----
                            AliyunSecretKey.setText(bundle.getString("AliyunSecretKey.text"));
                            AliyunSecretKey.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AliyunSecretKeyMouseClicked(e);
                                }
                            });
                            panel9.add(AliyunSecretKey);
                            AliyunSecretKey.setBounds(new Rectangle(new Point(115, 90), AliyunSecretKey.getPreferredSize()));

                            //---- AliyunOssUrl ----
                            AliyunOssUrl.setText(bundle.getString("AliyunOssUrl.text"));
                            AliyunOssUrl.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AliyunOssUrlMouseClicked(e);
                                }
                            });
                            panel9.add(AliyunOssUrl);
                            AliyunOssUrl.setBounds(new Rectangle(new Point(215, 90), AliyunOssUrl.getPreferredSize()));

                            //---- label15 ----
                            label15.setText(bundle.getString("label15.text"));
                            panel9.add(label15);
                            label15.setBounds(new Rectangle(new Point(20, 125), label15.getPreferredSize()));

                            //---- AWSAccessKeyId ----
                            AWSAccessKeyId.setText(bundle.getString("AWSAccessKeyId.text"));
                            AWSAccessKeyId.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AWSAccessKeyIdMouseClicked(e);
                                }
                            });
                            panel9.add(AWSAccessKeyId);
                            AWSAccessKeyId.setBounds(new Rectangle(new Point(15, 150), AWSAccessKeyId.getPreferredSize()));

                            //---- AWSAuthToken ----
                            AWSAuthToken.setText(bundle.getString("AWSAuthToken.text"));
                            AWSAuthToken.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AWSAuthTokenMouseClicked(e);
                                }
                            });
                            panel9.add(AWSAuthToken);
                            AWSAuthToken.setBounds(new Rectangle(new Point(130, 150), AWSAuthToken.getPreferredSize()));

                            //---- AWSURL ----
                            AWSURL.setText(bundle.getString("AWSURL.text"));
                            AWSURL.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AWSURLMouseClicked(e);
                                }
                            });
                            panel9.add(AWSURL);
                            AWSURL.setBounds(new Rectangle(new Point(245, 150), AWSURL.getPreferredSize()));

                            //---- label16 ----
                            label16.setText(bundle.getString("label16.text"));
                            panel9.add(label16);
                            label16.setBounds(new Rectangle(new Point(20, 185), label16.getPreferredSize()));

                            //---- SSHkey ----
                            SSHkey.setText(bundle.getString("SSHkey.text"));
                            SSHkey.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    SSHkeyMouseClicked(e);
                                }
                            });
                            panel9.add(SSHkey);
                            SSHkey.setBounds(new Rectangle(new Point(15, 210), SSHkey.getPreferredSize()));

                            //---- RSAKEYbutton ----
                            RSAKEYbutton.setText(bundle.getString("RSAKEYbutton.text"));
                            RSAKEYbutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    RSAKEYbuttonMouseClicked(e);
                                }
                            });
                            panel9.add(RSAKEYbutton);
                            RSAKEYbutton.setBounds(new Rectangle(new Point(110, 210), RSAKEYbutton.getPreferredSize()));

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel9.getComponentCount(); i++) {
                                    Rectangle bounds = panel9.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel9.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel9.setMinimumSize(preferredSize);
                                panel9.setPreferredSize(preferredSize);
                            }
                        }
                        tabbedPane3.addTab(bundle.getString("panel9.tab.title"), panel9);
                    }
                    REs.add(tabbedPane3);
                    tabbedPane3.setBounds(0, 0, 760, 355);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < REs.getComponentCount(); i++) {
                            Rectangle bounds = REs.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = REs.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        REs.setMinimumSize(preferredSize);
                        REs.setPreferredSize(preferredSize);
                    }
                }
                JtabbedPanel.addTab(bundle.getString("REs.tab.title"), REs);

                //======== DeCodeAndEnCodes ========
                {
                    DeCodeAndEnCodes.setLayout(null);

                    //======== DeAndEnCodeBase64s ========
                    {
                        DeAndEnCodeBase64s.setTabPlacement(SwingConstants.LEFT);

                        //======== Base64DeCodes ========
                        {
                            Base64DeCodes.setLayout(null);

                            //---- label1 ----
                            label1.setText(bundle.getString("label1.text"));
                            Base64DeCodes.add(label1);
                            label1.setBounds(new Rectangle(new Point(25, 10), label1.getPreferredSize()));

                            //---- label2 ----
                            label2.setText(bundle.getString("label2.text"));
                            Base64DeCodes.add(label2);
                            label2.setBounds(30, 165, label2.getPreferredSize().width, 21);

                            //======== scrollPane10 ========
                            {
                                scrollPane10.setViewportView(Bas64DeTextArea);
                            }
                            Base64DeCodes.add(scrollPane10);
                            scrollPane10.setBounds(25, 195, 650, 140);

                            //---- Babut1EnCode ----
                            Babut1EnCode.setText(bundle.getString("Babut1EnCode.text"));
                            Babut1EnCode.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    Babut1EnCodeMouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(Babut1EnCode);
                            Babut1EnCode.setBounds(new Rectangle(new Point(185, 160), Babut1EnCode.getPreferredSize()));

                            //---- Babut2DeCode ----
                            Babut2DeCode.setText(bundle.getString("Babut2DeCode.text"));
                            Babut2DeCode.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    Babut2DeCodeMouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(Babut2DeCode);
                            Babut2DeCode.setBounds(new Rectangle(new Point(320, 160), Babut2DeCode.getPreferredSize()));

                            //---- Base64buttonSwap ----
                            Base64buttonSwap.setText(bundle.getString("Base64buttonSwap.text"));
                            Base64buttonSwap.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    button2MouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(Base64buttonSwap);
                            Base64buttonSwap.setBounds(new Rectangle(new Point(460, 160), Base64buttonSwap.getPreferredSize()));

                            //======== scrollPane11 ========
                            {
                                scrollPane11.setViewportView(Base64EnsTextArea);
                            }
                            Base64DeCodes.add(scrollPane11);
                            scrollPane11.setBounds(25, 30, 650, 125);

                            //---- BaCopyResButton ----
                            BaCopyResButton.setText(bundle.getString("BaCopyResButton.text"));
                            BaCopyResButton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    BaCopyResButtonMouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(BaCopyResButton);
                            BaCopyResButton.setBounds(new Rectangle(new Point(25, 340), BaCopyResButton.getPreferredSize()));
                            Base64DeCodes.add(BaCopyEcholabel);
                            BaCopyEcholabel.setBounds(130, 340, 170, 30);

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
                    DeAndEnCodeBase64s.setBounds(0, 0, 760, 380);

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

                //======== RandomMenu ========
                {
                    RandomMenu.setLayout(null);

                    //======== scrollPane6 ========
                    {

                        //======== tabbedPane5 ========
                        {
                            tabbedPane5.setTabPlacement(SwingConstants.LEFT);

                            //======== panel2 ========
                            {
                                panel2.setLayout(null);

                                //---- RandomButton ----
                                RandomButton.setText(bundle.getString("RandomButton.text"));
                                RandomButton.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        RandomButtonMouseClicked(e);
                                    }
                                });
                                panel2.add(RandomButton);
                                RandomButton.setBounds(new Rectangle(new Point(10, 10), RandomButton.getPreferredSize()));
                                panel2.add(RandomTextField);
                                RandomTextField.setBounds(10, 70, 425, 35);

                                //---- ABCcheckBox ----
                                ABCcheckBox.setText(bundle.getString("ABCcheckBox.text"));
                                panel2.add(ABCcheckBox);
                                ABCcheckBox.setBounds(new Rectangle(new Point(20, 45), ABCcheckBox.getPreferredSize()));

                                //---- abcckBox ----
                                abcckBox.setText(bundle.getString("abcckBox.text"));
                                panel2.add(abcckBox);
                                abcckBox.setBounds(80, 45, 47, 22);

                                //---- NumcheckBox ----
                                NumcheckBox.setText(bundle.getString("NumcheckBox.text"));
                                panel2.add(NumcheckBox);
                                NumcheckBox.setBounds(140, 45, 47, 22);

                                //---- SigncheckBox ----
                                SigncheckBox.setText(bundle.getString("SigncheckBox.text"));
                                panel2.add(SigncheckBox);
                                SigncheckBox.setBounds(200, 45, 47, 22);
                                panel2.add(PasswordLens);
                                PasswordLens.setBounds(new Rectangle(new Point(320, 40), PasswordLens.getPreferredSize()));

                                //---- label4 ----
                                label4.setText(bundle.getString("label4.text"));
                                panel2.add(label4);
                                label4.setBounds(new Rectangle(new Point(265, 45), label4.getPreferredSize()));

                                //---- CopyPasswordbutton ----
                                CopyPasswordbutton.setText(bundle.getString("CopyPasswordbutton.text"));
                                CopyPasswordbutton.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        CopyPasswordbuttonMouseClicked(e);
                                    }
                                });
                                panel2.add(CopyPasswordbutton);
                                CopyPasswordbutton.setBounds(new Rectangle(new Point(455, 75), CopyPasswordbutton.getPreferredSize()));

                                {
                                    // compute preferred size
                                    Dimension preferredSize = new Dimension();
                                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                                        Rectangle bounds = panel2.getComponent(i).getBounds();
                                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                    }
                                    Insets insets = panel2.getInsets();
                                    preferredSize.width += insets.right;
                                    preferredSize.height += insets.bottom;
                                    panel2.setMinimumSize(preferredSize);
                                    panel2.setPreferredSize(preferredSize);
                                }
                            }
                            tabbedPane5.addTab(bundle.getString("panel2.tab.title"), panel2);
                        }
                        scrollPane6.setViewportView(tabbedPane5);
                    }
                    RandomMenu.add(scrollPane6);
                    scrollPane6.setBounds(5, 0, 750, 375);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < RandomMenu.getComponentCount(); i++) {
                            Rectangle bounds = RandomMenu.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = RandomMenu.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        RandomMenu.setMinimumSize(preferredSize);
                        RandomMenu.setPreferredSize(preferredSize);
                    }
                }
                JtabbedPanel.addTab(bundle.getString("RandomMenu.tab.title"), RandomMenu);

                //======== Custom ========
                {
                    Custom.setLayout(new BoxLayout(Custom, BoxLayout.X_AXIS));

                    //======== scrollPane5 ========
                    {

                        //======== CustomEditOptions ========
                        {
                            CustomEditOptions.setTabPlacement(SwingConstants.LEFT);

                            //======== CustomSaveJp ========
                            {
                                CustomSaveJp.setLayout(null);

                                //---- label42 ----
                                label42.setText(bundle.getString("label42.text"));
                                CustomSaveJp.add(label42);
                                label42.setBounds(new Rectangle(new Point(30, 20), label42.getPreferredSize()));

                                {
                                    // compute preferred size
                                    Dimension preferredSize = new Dimension();
                                    for(int i = 0; i < CustomSaveJp.getComponentCount(); i++) {
                                        Rectangle bounds = CustomSaveJp.getComponent(i).getBounds();
                                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                    }
                                    Insets insets = CustomSaveJp.getInsets();
                                    preferredSize.width += insets.right;
                                    preferredSize.height += insets.bottom;
                                    CustomSaveJp.setMinimumSize(preferredSize);
                                    CustomSaveJp.setPreferredSize(preferredSize);
                                }
                            }
                            CustomEditOptions.addTab(bundle.getString("CustomSaveJp.tab.title"), CustomSaveJp);

                            //======== CustomEdit1IOptions ========
                            {

                                //---- CustomEdit1TextArea ----
                                CustomEdit1TextArea.setText(bundle.getString("CustomEdit1TextArea.text"));
                                CustomEdit1IOptions.setViewportView(CustomEdit1TextArea);
                            }
                            CustomEditOptions.addTab("\u81ea\u5b9a\u4e49\u7f16\u8f91\u533a\u57df", CustomEdit1IOptions);
                        }
                        scrollPane5.setViewportView(CustomEditOptions);
                    }
                    Custom.add(scrollPane5);
                }
                JtabbedPanel.addTab(bundle.getString("Custom.tab.title"), Custom);
            }
            Panel2.add(JtabbedPanel);
            JtabbedPanel.setBounds(20, 25, 760, 420);

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
        Panel2.setBounds(0, 135, 795, 455);
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(30, 10), label3.getPreferredSize()));

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
    private JLabel FileName;
    private JTextField FileNameVaule;
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
    private JTextArea Bash1TextArea;
    private JScrollPane scrollPane1;
    private JTextArea Bash2TextArea;
    private JScrollPane JavaBashOption;
    private JTextArea JavaBashTextArea;
    private JPanel RCEMenu;
    private JTabbedPane CurlOption;
    private JPanel panel3;
    private JLabel label6;
    private JTextField Curl2TextField;
    private JLabel label8;
    private JTextField Curl1TextField;
    private JLabel label7;
    private JLabel label9;
    private JPanel WgetOption;
    private JScrollPane scrollPane7;
    private JTextArea Wget1TextArea;
    private JPanel PythonOption;
    private JScrollPane scrollPane12;
    private JTextArea PythonTextArea;
    private JTabbedPane msfs;
    private JPanel LinuxPayloadOptions;
    private JLabel label33;
    private JTextField msfLinuxHexTextField;
    private JLabel label34;
    private JTextField msfLinuxELFTextField;
    private JPanel msfListenerOptions;
    private JLabel label36;
    private JLabel label37;
    private JScrollPane scrollPane16;
    private JTextArea msfLinuxListenerTextArea;
    private JScrollPane scrollPane17;
    private JTextArea msfWindowsListenerTextArea;
    private JPanel msfRootOptions;
    private JTextField msfRootTextField;
    private JLabel label28;
    private JButton msfCopyRootButton;
    private JLabel label29;
    private JButton msfCopyRootButton2;
    private JLabel label31;
    private JTextField sessionIdTextField;
    private JScrollPane scrollPane15;
    private JTextArea msfRootTextArea;
    private JTextField msfPayloadCopyTextField;
    private JLabel label32;
    private JTabbedPane Stoways;
    private JPanel AdminOptions;
    private JLabel label5;
    private JScrollPane scrollPane4;
    private JTextArea stAdminTextArea;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JTextField stSocksTextField;
    private JButton stCopyIpSocksButton;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private JLabel label27;
    private JPanel AgentOptions;
    private JLabel label17;
    private JLabel label18;
    private JScrollPane scrollPane13;
    private JTextArea stLinuxAgentTextArea;
    private JScrollPane scrollPane14;
    private JTextArea stWindowsAgentTextArea;
    private JPanel JavaMenu;
    private JTabbedPane tabbedPane4;
    private JPanel FastjsonOptions;
    private JLabel label38;
    private JTextField textField5;
    private JLabel label39;
    private JScrollPane scrollPane18;
    private JTextArea FaDNSlogTextArea;
    private JPanel FaEXP1Options;
    private JScrollPane FaEXP1;
    private JTextArea FaEXP1TextArea;
    private JButton FaCopyEXP1TextArea;
    private JLabel FaCopyEcholabel;
    private JPanel Log4j2Options;
    private JLabel label40;
    private JTextField LoIPTextArea;
    private JLabel label41;
    private JTextField LoDNSlogTextArea;
    private JPanel REs;
    private JTabbedPane tabbedPane3;
    private JPanel panel9;
    private JLabel label11;
    private JLabel label12;
    private JButton IPCopybutton;
    private JLabel CopyEcholabel;
    private JButton URLCopybutton;
    private JButton URLPathbutton;
    private JButton URLPortbutton;
    private JButton AliyunaAccessKey;
    private JLabel label10;
    private JLabel label13;
    private JLabel label14;
    private JButton AliyunSecretKey;
    private JButton AliyunOssUrl;
    private JLabel label15;
    private JButton AWSAccessKeyId;
    private JButton AWSAuthToken;
    private JButton AWSURL;
    private JLabel label16;
    private JButton SSHkey;
    private JButton RSAKEYbutton;
    private JPanel DeCodeAndEnCodes;
    private JTabbedPane DeAndEnCodeBase64s;
    private JPanel Base64DeCodes;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane10;
    private JTextArea Bas64DeTextArea;
    private JButton Babut1EnCode;
    private JButton Babut2DeCode;
    private JButton Base64buttonSwap;
    private JScrollPane scrollPane11;
    private JTextArea Base64EnsTextArea;
    private JButton BaCopyResButton;
    private JLabel BaCopyEcholabel;
    private JPanel RandomMenu;
    private JScrollPane scrollPane6;
    private JTabbedPane tabbedPane5;
    private JPanel panel2;
    private JButton RandomButton;
    private JTextField RandomTextField;
    private JCheckBox ABCcheckBox;
    private JCheckBox abcckBox;
    private JCheckBox NumcheckBox;
    private JCheckBox SigncheckBox;
    private JSpinner PasswordLens;
    private JLabel label4;
    private JButton CopyPasswordbutton;
    private JPanel Custom;
    private JScrollPane scrollPane5;
    private JTabbedPane CustomEditOptions;
    private JPanel CustomSaveJp;
    private JLabel label42;
    private JScrollPane CustomEdit1IOptions;
    private JTextArea CustomEdit1TextArea;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
