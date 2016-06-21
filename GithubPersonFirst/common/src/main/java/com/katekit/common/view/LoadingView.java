package com.katekit.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.katekit.common.R;


/**
 * Project Name：workplace
 * Packagee Name：  com.chinanetcenter.broadband.view
 * Description：
 *
 * @author: huangmc
 * @date: 2015/10/29 10:14
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class LoadingView extends View {

    private Context mContext;
    public LoadingView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    private void init() {

    }
    Paint p = new Paint();
    float value=0f;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setStrokeWidth(LoadingView.this.getHeight());
        p.setColor(mContext.getResources().getColor(R.color.gray));
        canvas.drawLine(0, 0, LoadingView.this.getWidth(), 0, p);// 画线
        p.setColor(Color.WHITE);
        canvas.drawLine(0, 0, value*LoadingView.this.getWidth(), 0, p);// 画线
    }


    public void startMyAnimation(int timePaly) {
        
        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                super.applyTransformation(interpolatedTime, t);
                value=interpolatedTime;
                LoadingView.this.invalidate();
            }
        };
        animation.setDuration(timePaly);
        this.startAnimation(animation);
    }
    public void setStartView() {

        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                super.applyTransformation(interpolatedTime, t);
                value=0;
                LoadingView.this.invalidate();
            }
        };
        animation.setDuration(1);
        this.startAnimation(animation);
    }
}
