/************************************************************
 *	版权�?�?  (c)2013,   蔡志�?<p>	
 *  文件名称	：NoCancelDialog.java<p>
 *
 *  创建时间	�?2016-1-17 下午4:24:07 
 *  当前版本号：v1.0
 ************************************************************/
package com.katekit.common.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.Window;

import java.lang.reflect.Method;

/************************************************************
 *  ����ժҪ	��<p>
 *
 *  ����	����־��
 *  ����ʱ��	��2016-1-17 ����4:24:07
 *  ��ǰ�汾�ţ�v1.0
 ************************************************************/
public class NoCancelDialog extends Dialog {

	/**
	 * ���캯����
	 * ��������:
	 * ����˵����
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
	 *  �������� ��onAttachedToWindow
	 *  �������� ��
	 *  ����˵�� ��
	 *  ����ֵ��
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
	 *  �������� ��dispatchKeyEvent
	 *  �������� ��
	 *  ����˵�� ��
	 *  	@param event
	 *  	@return
	 *  ����ֵ��
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// ���ε�HOME����
		if (event.getKeyCode() == KeyEvent.KEYCODE_HOME) {
			return true;
		}
		// ���ε�MENU����
		if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
			return true;
		}
		return super.dispatchKeyEvent(event);
	}
}
