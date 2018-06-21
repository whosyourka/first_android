package com.katekit.common.util.px2dp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;

/**
 * Created by 黄明灿 on 2017/7/12 18:59.
 * Describe : 屏幕像素
 */
public class DensityUtil {
    public static void setMaxWidth(Context context, Dialog dialog) {
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = (int) (display.getWidth()); // 设置宽度
        dialog.getWindow().setAttributes(lp);
    }

    public static void setMax(Context context, Dialog dialog) {
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.height = (int) (display.getHeight()); // 设置高度
        lp.width = (int) (display.getWidth()); // 设置宽度
        dialog.getWindow().setAttributes(lp);
    }

    /**
     * 获取屏幕密度
     *
     * @param context
     */
    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获取屏幕的宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) context)
                .getWindowManager().getDefaultDisplay().getMetrics(metric);
        int screenWidth = metric.widthPixels;
        return screenWidth;
    }

    /**
     * 根据比例计算高度
     *
     * @param context
     * @param ratio
     * @return
     */
    public static int getHeightByRatio(Context context, double ratio) {
        int screenWidth = getScreenWidth(context);
        int height = (int) (screenWidth * ratio);
        return height;
    }

    /**
     * 获取屏幕宽度和高度，单位为px
     *
     * @param context
     * @return
     */
    public static Point getScreenMetrics(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int h_screen = dm.heightPixels;
        return new Point(w_screen, h_screen);

    }

    /**
     * 获取屏幕长宽比
     *
     * @param context
     * @return
     */
    public static float getScreenRate(Context context) {
        Point P = getScreenMetrics(context);
        float H = P.y;
        float W = P.x;
        return (H / W);
    }
}
