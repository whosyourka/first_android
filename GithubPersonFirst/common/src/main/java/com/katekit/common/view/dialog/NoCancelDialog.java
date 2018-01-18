/************************************************************
 *	鐗堟潈鎵?鏈?  (c)2013,   钄″織鏋?<p>	
 *  鏂囦欢鍚嶇О	锛歂oCancelDialog.java<p>
 *
 *  鍒涘缓鏃堕棿	锛?2016-1-17 涓嬪崍4:24:07 
 *  褰撳墠鐗堟湰鍙凤細v1.0
 ************************************************************/
package com.katekit.common.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.Window;

import java.lang.reflect.Method;

/************************************************************
 *  内容摘要	：<p>
 *
 *  作者	：蔡志林
 *  创建时间	：2016-1-17 下午4:24:07
 *  当前版本号：v1.0
 ************************************************************/
public class NoCancelDialog extends Dialog {

	/**
	 * 构造函数：
	 * 函数功能:
	 * 参数说明：
	 * 		@param context
	 */
	public NoCancelDialog(Context context) {
		super(context);
	}

	public NoCancelDialog(Context context, boolean cancelable,
                          OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

	public NoCancelDialog(Context context, int theme) {
		super(context, theme);
	}

	/**
	 *  函数名称 ：onAttachedToWindow
	 *  功能描述 ：
	 *  参数说明 ：
	 *  返回值：
	 */
	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();

		Window window = getWindow();
		try {
			Class<?> cls = window.getClass();
			final Class<?>[] PARAM_TYPES = new Class[] { int.class };
			Method method = cls.getMethod("addCustomFlags", PARAM_TYPES);
			method.setAccessible(true);
			method.invoke(window, new Object[] { 0x00000001 });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  函数名称 ：dispatchKeyEvent
	 *  功能描述 ：
	 *  参数说明 ：
	 *  	@param event
	 *  	@return
	 *  返回值：
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// 屏蔽掉HOME按键
		if (event.getKeyCode() == KeyEvent.KEYCODE_HOME) {
			return true;
		}
		// 屏蔽掉MENU按键
		if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
			return true;
		}
		return super.dispatchKeyEvent(event);
	}
}
