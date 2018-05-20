package com.landi.initapplication.util.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class NetUtils {

    /**
     * 判断当前网络是否可用
     *
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (mConnectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * 判断当前wifi是否可用
     *
     * @return
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable() && mWiFiNetworkInfo.isConnected();
            }
        }
        return false;
    }

//    public String getMacFromWifi() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo.State wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
//        if (wifiState == NetworkInfo.State.CONNECTED) {//判断当前是否使用wifi连接
//            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//            if (!wifiManager.isWifiEnabled()) { //如果当前wifi不可用
//                wifiManager.setWifiEnabled(true);
//            }
//            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//            return wifiInfo.getMacAddress();
//        }
//        return null;
//    }
//
//    public String getSSIDFromWifi() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo.State wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
//        if (wifiState == NetworkInfo.State.CONNECTED) {//判断当前是否使用wifi连接
//            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//            if (!wifiManager.isWifiEnabled()) { //如果当前wifi不可用
//                wifiManager.setWifiEnabled(true);
//            }
//            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//            String ssid = wifiInfo.getSSID().replace("\"", "");
//            return ssid;
//        }
//        return null;
//    }
//
//
//    /**
//     * 获取网关地址
//     *
//     * @return
//     */
//    public String getGatewayFromWifi() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo.State wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
//        if (wifiState == NetworkInfo.State.CONNECTED) {//判断当前是否使用wifi连接
//            WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//            DhcpInfo di = wm.getDhcpInfo();
//            long getewayIpL = di.gateway;
//            String getwayIpS = long2ip(getewayIpL);//网关地址
//            return getwayIpS;
//        }
//        return null;
//    }
//
//    public static String long2ip(long ip) {
//        int[] b = new int[4];
//        b[0] = (int) ((ip >> 24) & 0xff);
//        b[1] = (int) ((ip >> 16) & 0xff);
//        b[2] = (int) ((ip >> 8) & 0xff);
//        b[3] = (int) (ip & 0xff);
//        String x;
//        x = Integer.toString(b[3]) + "." + Integer.toString(b[2]) + "."
//                + Integer.toString(b[1]) + "." + Integer.toString(b[0]);
//        return x;
//    }

    /**
     * 判断MOBILE网络是否可用
     *
     * @return
     */
    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable() && mMobileNetworkInfo.isConnected();
            }
        }
        return false;
    }
    public static boolean isEthernetConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable() && mMobileNetworkInfo.isConnected();
            }
        }
        return false;
    }
}
