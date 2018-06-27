package com.katekit.common.view.recycleview;

import android.view.View;
import android.widget.AdapterView;

/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband.view
 * Description：
 *
 * @author: huangmc
 * @date: 2015/9/9 13:55
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public abstract class PreventDoubleClickListener implements View.OnClickListener,AdapterView.OnItemClickListener{
    private final long INTERVAL = 600;

    private long mLastClickTime = 0;

    public void onMyOnClick(View v){};
    public void onMyOnClick(AdapterView<?> parent, View view, int position, long id){};

    @Override
    public void onClick(View v) {
        long currentClickTime = System.currentTimeMillis();
        if (currentClickTime - mLastClickTime > INTERVAL){
            mLastClickTime = currentClickTime;
            onMyOnClick(v);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        long currentClickTime = System.currentTimeMillis();
        if (currentClickTime - mLastClickTime > INTERVAL){
            mLastClickTime = currentClickTime;
            onMyOnClick(parent, view, position, id);
        }
    }

}
