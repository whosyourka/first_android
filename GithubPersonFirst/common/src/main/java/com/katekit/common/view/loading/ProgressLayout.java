package com.katekit.common.view.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.katekit.common.R;


/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband.view
 * Description：
 *
 * @author: huangmc
 * @date: 2015/8/7 9:31
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class ProgressLayout extends RelativeLayout {

    public ProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.processing, this, true);
    }

    public void show() {
        setBackgroundColor(getResources().getColor(R.color.white));
        this.setVisibility(View.VISIBLE);
    }

    public void hide() {
        this.setVisibility(View.GONE);
    }
}