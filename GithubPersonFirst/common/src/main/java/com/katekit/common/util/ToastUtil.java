package com.katekit.common.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by »ÆÃ÷²Ó on 2017/7/12 16:59.
 */
public class ToastUtil {

    private static String oldMsg;
    protected static Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;

    public static void show(Context context, String s) {
        if (toast == null) {
            toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
            toast.show();
//            oneTime = System.currentTimeMillis();
        } else {
//            twoTime = System.currentTimeMillis();
            toast.cancel();
            toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
            toast.show();
//            if (s != null && s.equals(oldMsg)) {
//                if (twoTime - oneTime > 200) {
//                    Log.i(TAG,"toast show");
//                    toast.show();
//                }
//            } else {
//                oldMsg = s;
//                toast.setText(s);
//                toast.show();
//            }
        }
//        oneTime = twoTime;
    }
    public static void show(Context context, String s, Boolean boolen) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT);
    }

    public static void show(Context context, int resId) {
        show(context, context.getString(resId));
    }

}
