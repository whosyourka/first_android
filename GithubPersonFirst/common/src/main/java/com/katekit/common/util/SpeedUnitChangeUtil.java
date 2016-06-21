package com.katekit.common.util;

/**
 * Project Name：router2
 * Packagee Name：  com.chinanetcenter.commonlibrary.util
 * Description：
 *
 * @author: huangmc
 * @date: 2016/5/3 18:34
 * Copyright (c) 2016年, Mr.huang . All Rights Reserved.
 */
public class SpeedUnitChangeUtil {
    public static String formatSize(float size)
    {
        long kb = 1024;
        long mb = (kb * 1024);
        long gb  = (mb * 1024);
        if (size < kb) {
            return String.format("%d B", (int) size);
        }
        else if (size < mb) {
            return String.format("%.1f KB", size / kb); //保留两位小数
        }
        else if (size < gb) {
            return String.format("%.1f MB", size / mb);
        }
        else {
            return String.format("%.1f GB", size / gb);
        }
    }
    public static String formatSizeNumber(float size)
    {
        long kb = 1024;
        long mb = (kb * 1024);
        long gb  = (mb * 1024);
        if (size < kb) {
            return String.format("%d", (int) size);
        }
        else if (size < mb) {
            return String.format("%.0f", size / kb); //保留两位小数
        }
        else if (size < gb) {
            return String.format("%.1f", size / mb);
        }
        else {
            return String.format("%.1f", size / gb);
        }
    }
    public static String formatSizeUnit(float size)
    {
        long kb = 1024;
        long mb = (kb * 1024);
        long gb  = (mb * 1024);
        if (size < kb) {
            return String.format("B");
        }
        else if (size < mb) {
            return String.format("KB"); //保留两位小数
        }
        else if (size < gb) {
            return String.format("MB");
        }
        else {
            return String.format("GB");
        }
    }
}
