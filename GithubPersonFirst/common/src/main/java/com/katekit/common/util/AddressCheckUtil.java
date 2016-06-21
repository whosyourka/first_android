package com.katekit.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddressCheckUtil
{   
    /**
     * 判断是否为手机号
     *
     */
    public static boolean isPhoneNum(String num)
    {
        Pattern pattern = Pattern.compile("^(1[0-9])\\d{9}$");
        Matcher matcher = pattern.matcher(num);

        if (matcher.matches())
        {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 判断是否为邮箱地址
     *
     */
    public static boolean isEmail(String email)
    {
        Pattern pattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches())
        {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 判断是否为qq号码
     *
     */
    public static boolean isQQNumber(String email)
    {
        Pattern pattern = Pattern.compile("^\\d{5,11}$");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches())
        {
            return true;
        }
        else {
            return false;
        }
    }

}
