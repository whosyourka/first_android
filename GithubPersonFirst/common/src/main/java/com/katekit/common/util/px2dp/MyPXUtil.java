/************************************************************
 *	版权�?�?  (c)2013,   蔡志�?<p>	
 *  文件名称	：Mypx2dpUtil.java<p>
 *
 *  创建时间	�?2016-1-25 下午3:27:58 
 *  当前版本号：v1.0
 ************************************************************/
package com.katekit.common.util.px2dp;

import android.content.Context;

/************************************************************
 *  ����ժҪ	��<p>
 *
 *  ����	����־��
 *  ����ʱ��	��2016-1-25 ����3:27:58
 *  ��ǰ�汾�ţ�v1.0
 ************************************************************/
public class MyPXUtil {
	/**pxֵת��dpֵ*/
	public static int px2dp(Context context, int pxValue){
		float scale = context.getResources().getDisplayMetrics().density;
		return (int)(pxValue / scale + 0.5f);
	}
	/**dpֵת��pxֵ*/
	public static int dp2px(Context context, int dpValue){
		float scale = context.getResources().getDisplayMetrics().density;
		return (int)(dpValue * scale + 0.5f);
	}

    /**pxֵת��spֵ*/
	public static int px2sp(Context context, int pxValue){
		float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
	    return (int) (pxValue / fontScale + 0.5f);
	}
    /**spֵת��pxֵ*/
	public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity; 
        return (int) (spValue * fontScale + 0.5f); 
    }
}
