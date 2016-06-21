package com.katekit.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/*
 * EditText支持多行同时支持imeOptions设置  (响应键盘上的imeOption)
 * EditText一旦设置了多行显示，键盘总是显示Enter键。有时候我们只需要文本输入多行显示，Enter键任然需要支持imeOptions设置，
 * 比如显示完成键而不是回车换行。
 * 当EditText的inputType包含textMultiLine标志位，会强迫imeOptions加上IME_FLAG_NO_ENTER_ACTION位，
 * 这导致了只显示Enter键。所以要去掉
 */
public class EditTextEx extends EditText {
	// mTouchEventFlag - 本控件是否响应点击事件
	private boolean mTouchEventFlag = true;
	
	public void setTouchEventFlag(boolean flag){
		mTouchEventFlag = flag;
	}

	public EditTextEx(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
		InputConnection connection = super.onCreateInputConnection(outAttrs);
		if (connection == null){
			return null;
		}
		// 移除EditorInfo.IME_FLAG_NO_ENTER_ACTION标志位
		outAttrs.imeOptions &= ~EditorInfo.IME_FLAG_NO_ENTER_ACTION;
		return connection;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (mTouchEventFlag){
			return super.onTouchEvent(event);
		}else{
			return false;
		}
	}

	public String getTextString() {
		return getText().toString().trim();
	}
}
