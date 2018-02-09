package com.katekit.common.util.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;


@SuppressLint("NewApi")
public class NetUtils {
    private Context context;

    public NetUtils(Context context) {
        this.context = context;
    }

    /**
     * 判断当前网络是否可用
     *
     * @return
     */
    public boolean isNetworkConnected() {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (mConnectivityManager == null) {
                return false;
            }
            NetworkInfo[] infos = mConnectivityManager.getAllNetworkInfo();
            if (infos != null) {
                for (NetworkInfo info : infos) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 判断当前wifi是否可用
     *
     * @return
     */
    public boolean isWifiConnected() {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isConnected();
            }
        }
        return false;
    }

    public String getMacFromWifi() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        if (wifiState == NetworkInfo.State.CONNECTED) {//判断当前是否使用wifi连接
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            if (!wifiManager.isWifiEnabled()) { //如果当前wifi不可用
                wifiManager.setWifiEnabled(true);
            }
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            return wifiInfo.getMacAddress();
        }
        return null;
    }

    public String getSSIDFromWifi() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        if (wifiState == NetworkInfo.State.CONNECTED) {//判断当前是否使用wifi连接
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            if (!wifiManager.isWifiEnabled()) { //如果当前wifi不可用
                wifiManager.setWifiEnabled(true);
            }
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            String ssid = wifiInfo.getSSID().replace("\"", "");
            return ssid;
        }
        return null;
    }


    /**
     * 获取网关地址
     *
     * @return
     */
    public String getGatewayFromWifi() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State wifiState = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        if (wifiState == NetworkInfo.State.CONNECTED) {//判断当前是否使用wifi连接
            WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            DhcpInfo di = wm.getDhcpInfo();
            long getewayIpL = di.gateway;
            String getwayIpS = long2ip(getewayIpL);//网关地址
            return getwayIpS;
        }
        return null;
    }

    public static String long2ip(long ip) {
        int[] b = new int[4];
        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        String x;
        x = Integer.toString(b[3]) + "." + Integer.toString(b[2]) + "."
                + Integer.toString(b[1]) + "." + Integer.toString(b[0]);
        return x;
    }

    /**
     * 判断MOBILE网络是否可用
     *
     * @return
     */
    public boolean isMobileConnected() {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 获取当前网络连接的类型信息 1 wifi 2 移动网络 -1 无网络
     *
     * @return
     */
    public int getConnectedType() {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType() == mConnectivityManager.TYPE_WIFI ? 1
                        : 2;
            }
        }
        return -1;
    }
}
