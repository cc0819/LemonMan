package com.cheng.cc.lemonman.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by c.c on 2017/2/26.
 * 常量类
 */

public class Constants {
    public static final String URLHeaderBase = "http://api";

    public static final long EXITTIME = 2000;

    public static final int CONNECTTIME = 60000;


    // 使AsyncTask可以并行执行
    public static ExecutorService exec = Executors.newCachedThreadPool();
    // 判断sdk版本是否大于11
    public static final boolean API_LEVEL_11 = android.os.Build.VERSION.SDK_INT > 11;


    //共享参数常量
    public static final String ISFIRST = "isFirst";


    //跳转数据常量
    public static final String PASSWORDCHANGE = "passwordchange";


    /**
     * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700,173
     **/
    public static final String CHINA_TELECOM_PATTERN = "(^1(33|53|7[37]|8[019])\\d{8}$)|(^1700\\d{7}$)";
    /**
     * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1707,1708,1709
     **/
    public static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^170[7-9]\\d{7}$)";

    /**
     * 中国移动号码格式验证
     * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184
     * ,187,188,147,178,1705
     **/
    public static final String CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";

    /**
     * 邮箱验证
     */
    public static final String CHINA_EMAIL_PATTERN = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

}
