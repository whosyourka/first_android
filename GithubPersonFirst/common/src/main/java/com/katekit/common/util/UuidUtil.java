package com.katekit.common.util;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Project Name：workplace
 * Packagee Name：  com.chinanetcenter.broadband.util
 * Description：
 *
 * @author: huangmc
 * @date: 2015/10/16 14:36
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class UuidUtil {
    /*
	 * 获取手机硬件标识码（设备id或者mac地址。）
	 */
    public static String getHardwareToken(Context context){
        String deviceId = getDeviceId(context);
        return (!TextUtils.isEmpty(deviceId)) ? deviceId : MobileUtil.getMacFromWifi(context);
    }

    /*
     * 获取手机设备id
     */
    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try {
            return telephonyManager.getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 获取设备唯一标识码。期望是由设备id+android id生成uuid。作为唯一识别码。
     * 如果由于设备id或者android id各自取值不正常，则使用随机的uuid生成机制，
     * 设备唯一标识码生成后保存到本地。
     */
    // get unique device token
    public static String getDeviceToken(Context context) {
        String savedDeviceId = SPHelper.readSP(context, "uuid");

        if (!TextUtils.isEmpty(savedDeviceId)) {
            return savedDeviceId;
        } else {
            UUID deviceUuid = null;
            String tmDevice = getHardwareToken(context);
            String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);


            if (!TextUtils.isEmpty(tmDevice)) {
                deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32));
            } else {
                // deviceId is null。有一些型号手机说是可能androidId一样，都是9774d56d682e549c
                if (!androidId.equals("9774d56d682e549c")) {
                    try {
                        deviceUuid = UUID.nameUUIDFromBytes(androidId.getBytes("utf8"));
                    } catch (UnsupportedEncodingException e) {

                        deviceUuid = UUID.randomUUID();
                        e.printStackTrace();
                    }
                } else {
                    deviceUuid = UUID.randomUUID();
                }
            }
            // 保存设备识别码
            SPHelper.writeSP(context,deviceUuid.toString(),"uuid");
            return deviceUuid.toString();
        }
    }

}
