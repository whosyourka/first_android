package com.katekit.common.util;

import java.math.BigDecimal;

/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband.util
 * Description：
 *
 * @author: huangmc
 * @date: 2015/9/15 17:57
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class BigDecimalUtil {
    public static double add(double d1,double d2){
        BigDecimal b1=new BigDecimal(Double.toString(d1));
        BigDecimal b2=new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();

    }

    public static double sub(double d1,double d2){
        BigDecimal b1=new BigDecimal(Double.toString(d1));
        BigDecimal b2=new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();

    }

    public static double mul(double d1,double d2){
        BigDecimal b1=new BigDecimal(Double.toString(d1));
        BigDecimal b2=new BigDecimal(Double.toString(d2));
        return b1.multiply(b2).doubleValue();
    }

    public static float mul(int d1,float d2){
        BigDecimal b1=new BigDecimal(Integer.toString(d1));
        BigDecimal b2=new BigDecimal(Float.toString(d2));
        return b1.multiply(b2).floatValue();
    }
}
