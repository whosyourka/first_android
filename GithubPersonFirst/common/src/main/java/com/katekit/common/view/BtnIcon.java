package com.katekit.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;

/**
 * Project Name： work
 * Packagee Name： com.landicorp.android.view
 * Description：
 *
 * @author: huangmc
 * @date: 18:23
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class BtnIcon extends View {
    private Context mContext;

    public BtnIcon(Context context) {
        super(context);
        this.mContext = context;
    }

    // 以下这个方法也可以把你的图片数组传过来，以StateListDrawable来设置图片状态，来表现button的各中状态。未选
    // 中，按下，选中效果。
    public StateListDrawable setbg(Integer[] mImageIds) {
        StateListDrawable bg = new StateListDrawable();
        Drawable normal = mContext.getResources().getDrawable(mImageIds[0]);
        Drawable selected = mContext.getResources().getDrawable(mImageIds[1]);
        bg.addState(View.PRESSED_ENABLED_STATE_SET, selected);
        bg.addState(View.ENABLED_FOCUSED_STATE_SET, selected);
        bg.addState(View.ENABLED_STATE_SET, normal);
        bg.addState(View.FOCUSED_STATE_SET, selected);
        bg.addState(View.EMPTY_STATE_SET, normal);
        return bg;
    }
}
