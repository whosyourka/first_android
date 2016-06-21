package com.katekit.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


public class SPHelper {
    public static final String ROUTER_SHARE_PREFERENCE_NAME = "router";

    public static boolean writeSP( Context context,String key,String name){
        SharedPreferences settings = context.getSharedPreferences(ROUTER_SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        DesUtil.init(context);
        String encryptData="";
        try {
            encryptData = DesUtil.encrypt(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        editor.putString(key, encryptData);
        editor.commit();
        return true;
    }
    public static String readSP(Context context,String key){
        SharedPreferences settings = context.getSharedPreferences(ROUTER_SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
        DesUtil.init(context);
        String encryptData = settings.getString(key, "");
        if (TextUtils.isEmpty(encryptData)) {
            return "";
        }

        String decryptData="";
        try {
            decryptData = DesUtil.decrypt(encryptData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decryptData;
    }
    public static String readSP(Context context,String key,String name){
        SharedPreferences settings = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        DesUtil.init(context);
        String encryptData = settings.getString(key, "");
        if (TextUtils.isEmpty(encryptData)) {
            return "";
        }

        String decryptData="";
        try {
            decryptData = DesUtil.decrypt(encryptData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decryptData;
    }

    public static boolean writeSP( Context context,String key,boolean name){
        SharedPreferences settings = context.getSharedPreferences(ROUTER_SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, name);
        editor.commit();
        return true;
    }
    public static boolean writeSP( Context context,String key,long value){
        SharedPreferences settings = context.getSharedPreferences(ROUTER_SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        editor.commit();
        return true;
    }
    public static boolean readBooleanSP( Context context,String key){
        SharedPreferences settings = context.getSharedPreferences(ROUTER_SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, false);
    }
    public static boolean readBooleanSPTrue( Context context,String key){
        SharedPreferences settings = context.getSharedPreferences(ROUTER_SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, true);
    }
    public static long readLongSP( Context context,String key){
        SharedPreferences settings = context.getSharedPreferences(ROUTER_SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getLong(key, 0);
    }



    public enum Pref {
        APP("app"), USER("user");

        private String ns;

        private Pref(String ns) {
            this.ns = ns;
        }

        public String getNameSpace() {
            return this.ns;
        }
    }

    public static final SharedPreferences getPref(Context context, Pref pref) {
        return context.getSharedPreferences(pref.getNameSpace(), Context.MODE_PRIVATE);
    }

    public static boolean needGuide(Context context) {
        SharedPreferences sp = getPref(context, Pref.APP);
        return sp.getBoolean("needGuide", true);
    }

    public static void cancelGuide(Context context) {
        SharedPreferences sp = getPref(context, Pref.APP);
        sp.edit().putBoolean("needGuide", false).commit();
    }


    public static boolean isCommentGood(Context context, String commentId) {
        SharedPreferences sp = getPref(context, Pref.APP);
        return sp.getBoolean("c" + commentId, false);
    }


    public static void setCommentGood(Context context, String commentId, boolean isGood) {
        SharedPreferences sp = getPref(context, Pref.APP);
        sp.edit().putBoolean("c" + commentId, isGood).commit();
    }

}
