package com.swordHostDemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date: 2022/12/29 12:48
 * @description: 时间戳转换
 */
public class timeStamp {
    public static String timeStampSimpleDate(String timeStampStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStampStr))));      // 时间戳转换成时间
        System.out.println("格式化结果：" + sd);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        String sd2 = sdf2.format(new Date(Long.parseLong(String.valueOf(timeStampStr))));
        System.out.println("格式化结果：" + sd2);
        return sdf+"\r\n"+sdf2;
    }

    public static void main(String[] args) {
        timeStampSimpleDate("1527767665");
    }
}
