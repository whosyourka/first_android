package com.katekit.common.util;

import android.content.Context;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband.util
 * Description：
 *
 * @author: huangmc
 * @date: 2015/9/17 13:46
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class PhoneNumberUtil {
    public static boolean setPhoneRight(Context context,String phone){
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showToast(context, "手机号不能为空");
            return false;
        }

        if (phone.length() != 11) {
            ToastUtil.showToast(context, "请输入11位手机号");
            return false;
        }
        if ((1 != Integer.parseInt(phone.substring(0, 1))) ||
                (3 != Integer.parseInt(phone.substring(1, 2))
                && 5 != Integer.parseInt(phone.substring(1, 2))
                && 7 != Integer.parseInt(phone.substring(1, 2))
                && 8 != Integer.parseInt(phone.substring(1, 2)))) {
            ToastUtil.showToast(context, "手机格式错误，请再次确认");
            return false;
        }
        return true;
    }
    public static boolean isPhone(String phone){
        if (TextUtils.isEmpty(phone)) {
            return false;
        }

        if (phone.length() != 11) {
            return false;
        }
        if ((1 != Integer.parseInt(phone.substring(0, 1))) ||
                (3 != Integer.parseInt(phone.substring(1, 2))
                && 5 != Integer.parseInt(phone.substring(1, 2))
                && 7 != Integer.parseInt(phone.substring(1, 2))
                && 8 != Integer.parseInt(phone.substring(1, 2)))) {
            return false;
        }
        return true;
    }


    public static boolean isEmail(String strEmail)
    {

        String strPattern = "^[a-zA-Z][//w//.-]*[a-zA-Z0-9]@[a-zA-Z0-9][//w//.-]*[a-zA-Z0-9]//.[a-zA-Z][a-zA-Z//.]*[a-zA-Z]$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strEmail);
        return m.matches();

    }
}
