package com.katekit.common.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;

/**
 * Project Name�� work
 * Packagee Name�� com.landicorp.android.view
 * Description��
 *
 * @author: huangmc
 * @date: 10:55
 * Copyright (c) 2015��, Mr.huang . All Rights Reserved.
 */
public class BaseDialog extends NoCancelDialog {
	public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;

    public BaseDialog(Context context) {
        super(context);
		this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);// �ؼ�����
    }

    public BaseDialog(Context context, int theme) {
        super(context, theme);
		this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);// �ؼ�����
    }

    protected BaseDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
		this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);// �ؼ�����
    }

    protected boolean diableHome(){
        return true;
    }
    protected boolean diableMenu(){
        return true;
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
            if (diableHome()) {
                return true;
            }
        }
        // ���ε�MENU����
        if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            if (diableMenu()) {
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
