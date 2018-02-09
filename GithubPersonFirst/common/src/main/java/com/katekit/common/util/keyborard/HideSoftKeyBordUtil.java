package com.katekit.common.util.keyborard;

import android.app.Activity;
import android.content.Context;
import android.text.InputType;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

public class HideSoftKeyBordUtil {

    private Activity activity;

    public HideSoftKeyBordUtil(Activity act) {
        this.activity = act;
    }


    public void hideSoftInputMethod(EditText ed) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        String methodName = null;
        if (currentVersion >= 16) {
            // 4.2
            methodName = "setShowSoftInputOnFocus";
        } else if (currentVersion >= 14) {
            // 4.0
            methodName = "setSoftInputShownOnFocus";
        }

        if (methodName == null) {
            ed.setInputType(InputType.TYPE_NULL);
        } else {
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnFocus;
            try {
                setShowSoftInputOnFocus = cls.getMethod(methodName, boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(ed, false);
            } catch (NoSuchMethodException e) {
                ed.setInputType(InputType.TYPE_NULL);
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    /**
     * @throws
     * @MethodName:closeInputMethod
     * @Description:关闭系统软键盘
     */

    public void closeInputMethod() {

        try {

            ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE))

                    .hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),

                            InputMethodManager.HIDE_NOT_ALWAYS);

        } catch (Exception e) {
        } finally {
        }

    }

    /**
     * @throws
     * @MethodName:openInputMethod
     * @Description:打开系统软键盘
     */

    public void openInputMethod(final EditText editText) {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {

                InputMethodManager inputManager = (InputMethodManager) editText

                        .getContext().getSystemService(

                                Context.INPUT_METHOD_SERVICE);

                inputManager.showSoftInput(editText, 0);

            }

        }, 200);

    }


}
