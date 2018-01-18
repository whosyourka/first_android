package com.katekit.common.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by »ÆÃ÷²Ó on 2017/10/11 10:49.
 */

public class UniqueId {
    public static String getIMEI(Context context){
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null) {
            return "-";
        } else {
            return deviceId;
        }
    }
}
