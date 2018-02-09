package com.katekit.common.util.net;

/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband.util
 * Description：
 *
 * @author: huangmc
 * @date: 2015/8/7 9:39
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class NetworkTypeUtil {
    public static final int TYPE_NONE = -1;
    public static final int TYPE_MOBILE = ConnectivityManager.TYPE_MOBILE;
    public static final int TYPE_WIFI = ConnectivityManager.TYPE_WIFI;
    public static final int TYPE_2G = TYPE_WIFI + 1;
    public static final int TYPE_3G = TYPE_WIFI + 2;
    public static final int TYPE_4G = TYPE_WIFI + 3;

    /**
     * 获取网络类型，简单的区分wifi，移动数据网，无网络络三种
     *
     * @return
     */
    public static int getNetworkType(Context context) {
        if (context==null)
        {
            return -1;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null) {
            if (!info.isAvailable()) {
                return TYPE_NONE;
            } else {
                if (info.getType() == ConnectivityManager.TYPE_WIFI && info.isConnected()) {
                    return TYPE_WIFI;
                } else if (info.getType() == ConnectivityManager.TYPE_MOBILE && info.isConnected()) {
                    return TYPE_MOBILE;
                }
            }
        }
        return TYPE_NONE;
    }

    /**
     * 获取网络类型名称，主要用在build http请求时候的参数
     *
     * @return
     */
    public static String getNetworkString(Context context) {
        int networkType = getNetworkType(context);
        if (networkType == TYPE_WIFI) {
            return "wifi";
        } else if (networkType == TYPE_MOBILE) {
            return "3g";
        } else {
            return "none";
        }
    }

    // 获取详细的网络信息，对于移动数据网，返回具体的网络制式in generation.
    public static int getSpecificNetworkType(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info == null || !info.isAvailable() || !info.isConnected()){
            return TYPE_NONE;
        }
        int type = TYPE_NONE;
        switch(info.getType()){
            case ConnectivityManager.TYPE_WIFI:
                type = TYPE_WIFI;
                break;
            case ConnectivityManager.TYPE_MOBILE:
                TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
                switch (telephonyManager.getNetworkType()) {
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                        type = TYPE_2G;
                        break;
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        type = TYPE_3G;
                        break;
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        type = TYPE_4G;
                        break;
                    default:
                        type = TYPE_NONE;
                        break;
                }
                break;
            default:
                type = TYPE_NONE;
                break;
        }
        return type;
    }

    // 把networkType转成字符串
    public static String toString(int networkType) {
        switch (networkType) {
            case NetworkTypeUtil.TYPE_NONE:
                return "None";
            case NetworkTypeUtil.TYPE_WIFI:
                return "Wifi";
            case NetworkTypeUtil.TYPE_MOBILE:
                return "Mobile";
            case NetworkTypeUtil.TYPE_2G:
                return "2G";
            case NetworkTypeUtil.TYPE_3G:
                return "3G";
            case NetworkTypeUtil.TYPE_4G:
                return "4G";
            default:
                return "None";
        }
    }

    public static boolean  isWifiState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    public static boolean isMobileState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        }
        return false;
    }


}