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
 * Created by ������ on 2017/7/12 18:59.
 * Describe : ��Ļ����
 */
public class DensityUtil {
    public static void setMaxWidth(Context context, Dialog dialog) {
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = (int) (display.getWidth()); // ���ÿ��
        dialog.getWindow().setAttributes(lp);
    }

    public static void setMax(Context context, Dialog dialog) {
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.height = (int) (display.getHeight()); // ���ø߶�
        lp.width = (int) (display.getWidth()); // ���ÿ��
        dialog.getWindow().setAttributes(lp);
    }

    /**
     * ��ȡ��Ļ�ܶ�
     *
     * @param context
     */
    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * ��pxֵת��Ϊdip��dpֵ����֤�ߴ��С����
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * ��dip��dpֵת��Ϊpxֵ����֤�ߴ��С����
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * ��pxֵת��Ϊspֵ����֤���ִ�С����
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * ��spֵת��Ϊpxֵ����֤���ִ�С����
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * ��ȡ��Ļ�Ŀ��
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
     * ���ݱ�������߶�
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
     * ��ȡ��Ļ��Ⱥ͸߶ȣ���λΪpx
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
     * ��ȡ��Ļ�����
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
