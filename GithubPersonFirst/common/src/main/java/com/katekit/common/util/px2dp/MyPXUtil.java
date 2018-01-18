/************************************************************
 *	鐗堟潈鎵?鏈?  (c)2013,   钄″織鏋?<p>	
 *  鏂囦欢鍚嶇О	锛歁ypx2dpUtil.java<p>
 *
 *  鍒涘缓鏃堕棿	锛?2016-1-25 涓嬪崍3:27:58 
 *  褰撳墠鐗堟湰鍙凤細v1.0
 ************************************************************/
package com.katekit.common.util.px2dp;

import android.content.Context;

/************************************************************
 *  内容摘要	：<p>
 *
 *  作者	：蔡志林
 *  创建时间	：2016-1-25 下午3:27:58
 *  当前版本号：v1.0
 ************************************************************/
public class MyPXUtil {
	/**px值转化dp值*/
	public static int px2dp(Context context, int pxValue){
		float scale = context.getResources().getDisplayMetrics().density;
		return (int)(pxValue / scale + 0.5f);
	}
	/**dp值转化px值*/
	public static int dp2px(Context context, int dpValue){
		float scale = context.getResources().getDisplayMetrics().density;
		return (int)(dpValue * scale + 0.5f);
	}

    /**px值转化sp值*/
	public static int px2sp(Context context, int pxValue){
		float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
	    return (int) (pxValue / fontScale + 0.5f);
	}
    /**sp值转化px值*/
	public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity; 
        return (int) (spValue * fontScale + 0.5f); 
    }
}
