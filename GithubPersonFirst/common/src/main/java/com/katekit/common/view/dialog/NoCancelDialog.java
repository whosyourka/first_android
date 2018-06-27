package com.katekit.common.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.Window;

import java.lang.reflect.Method;

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
