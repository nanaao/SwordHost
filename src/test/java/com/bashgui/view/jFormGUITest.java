package com.bashgui.view;

import org.junit.Test;

import javax.swing.*;

/**
 * @date: 2022/12/27 14:51
 * @description:
 */
public class jFormGUITest {
    @Test
    public void jFormGUITest1(){
        jFormGUI jFormGUI = new jFormGUI();
        jFormGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFormGUI.setVisible(true);
    }
}