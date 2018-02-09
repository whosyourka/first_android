package com.katekit.common.util.match;

import android.text.TextUtils;

/**
 * Created by huangxingzhan on 2017/10/20.
 */

public class MatchUtil {
    public static final String REGEX_PHONE = "^0{0,1}(13[0-9]|15[0-9]|18[0-9]|17[0-9]|14[0-9]|19[0-9]|16[0-9])[0-9]{8}$";

    public static final String REGEX_IDENTITY = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";

    //必须包字母和数字的组合长度在8-20之间
    public static final String REGEX_PASSWORD = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{8,20}$";
//    public static final String REGEX_PASSWORD = "^(?=.*\\d)(?=.*[a-zA-Z]).{8,20}$";

    public static boolean matchPhone(String phone) {
        return !TextUtils.isEmpty(phone) && phone.matches(REGEX_PHONE);
    }

    public static boolean matchIdentity(String identity) {
        return !TextUtils.isEmpty(identity) && identity.matches(REGEX_IDENTITY);
    }

    public static boolean matchPassword(String password) {
        return !TextUtils.isEmpty(password) && password.matches(REGEX_PASSWORD);
    }
}
