package com.katekit.common.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


public class KeyboardUtil
{
    /**
     * 打开软键盘
     * @param context
     * @param editText 输入框
     */
    public static void openKeyboard(Context context, EditText editText)
    {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);

    }

    /**
     * 关闭软键盘
     * @param context
     * @param editText 输入框
     */
    public static void closeKeyboard(Context context, EditText editText)
    {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
