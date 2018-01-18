package com.katekit.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;

/**
 * Project Name�� work
 * Packagee Name�� com.landicorp.android.view
 * Description��
 *
 * @author: huangmc
 * @date: 18:23
 * Copyright (c) 2015��, Mr.huang . All Rights Reserved.
 */
public class BtnIcon extends View {
    private Context mContext;

    public BtnIcon(Context context) {
        super(context);
        this.mContext = context;
    }

    // �����������Ҳ���԰����ͼƬ���鴫��������StateListDrawable������ͼƬ״̬��������button�ĸ���״̬��δѡ
    // �У����£�ѡ��Ч����
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
