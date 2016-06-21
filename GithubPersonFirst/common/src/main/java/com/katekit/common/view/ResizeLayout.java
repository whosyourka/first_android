package com.katekit.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * 监控软键盘弹起与收回的布局。根据前后高度大小变化判断软键盘是否弹起。
 * 注意所在的窗体属性SoftInputMode必须设置为为adjustResize，否则无效
 *
 * Created by caill on 2016/5/25.
 */
public class ResizeLayout extends LinearLayout{

    public ResizeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (oldh > 0) {
            if (h < oldh) {
                //软键盘弹出
                if (onSoftKeyboardListener != null) {
                    onSoftKeyboardListener.onShown();
                }
            } else if (h > oldh) {
                //软键盘隐藏
                if (onSoftKeyboardListener != null) {
                    onSoftKeyboardListener.onHidden();
                }
            }
        }
    }

    private OnSoftKeyboardListener onSoftKeyboardListener;

    public void setOnSoftKeyboardListener(final OnSoftKeyboardListener listener) {
        this.onSoftKeyboardListener = listener;
    }

    public interface OnSoftKeyboardListener {
        void onShown();
        void onHidden();
    }
}