package com.katekit.common.util.save;

import android.content.Context;
import android.content.SharedPreferences;


public class SPHelper {
    private static final String FILENAME = "ShareManager";

    /**
     * 获取应用程序的SharedPreferences句柄，只是在本类使用。
     *
     * @param context 不能为null,如果为null，那么返回null。
     * @return
     */
    private static SharedPreferences getAppSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
    }


    /**
     * 功能说明:保存设置开关值。
     *
     * @param context
     * @param key
     * @param value
     * @return
     * @throws null
     * @since v1.0
     */
    public static boolean setBooleanValue(Context context, String key,
                                          boolean value) {
        if (context == null) {
            return false;
        }
        try {
            SharedPreferences share = getAppSharedPreferences(context);
            SharedPreferences.Editor edi = share.edit();
            edi.putBoolean(key, value);
            edi.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * 功能说明:获取值。
     *
     * @param context
     * @param key
     * @return
     * @throws null
     * @since v1.0
     */
    public static boolean getBooleanValue(Context context, String key,
                                          boolean defaultValue) {
        if (context == null) {
            return defaultValue;
        }
        try {
            SharedPreferences share = getAppSharedPreferences(context);
            return share.getBoolean(key, defaultValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;

    }

    /**
     * 功能说明:设置值。
     *
     * @param context
     * @param key
     * @param value
     * @return
     * @throws null
     * @since v1.0
     */
    public static boolean setValue(Context context, String key, String value) {
        if (context == null) {
            return false;
        }
        try {
            SharedPreferences share = getAppSharedPreferences(context);
            SharedPreferences.Editor edi = share.edit();
            edi.putString(key, value);
            edi.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * 功能说明:获取值。
     *
     * @param context
     * @param key
     * @param defValue 默认值
     * @return
     * @throws null
     */
    public static String getValue(Context context, String key,
                                  String defValue) {
        if (context == null) {
            return defValue;
        }
        try {
            SharedPreferences share = getAppSharedPreferences(context);
            return share.getString(key, defValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;

    }



    /**
     * 功能说明:设置值。
     *
     * @param context
     * @param key
     * @param value
     * @throws null
     * @since v1.0
     */
    public static boolean setInt(Context context, String key, int value) {
        if (context == null) {
            return false;
        }
        try {
            SharedPreferences share = getAppSharedPreferences(context);
            SharedPreferences.Editor edi = share.edit();
            edi.putInt(key, value);
            edi.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * 功能说明:获取值。
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Context context, String key, int defaultValue) {

        if (context == null) {
            return defaultValue;
        }
        try {
            SharedPreferences share = getAppSharedPreferences(context);
            return share.getInt(key, defaultValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;

    }



}
