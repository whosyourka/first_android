package com.katekit.common.view.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.katekit.common.R;


/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband.view
 * Description：
 *
 * @author: huangmc
 * @date: 2015/8/9 15:40
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class TipsView extends FrameLayout {
    private DataLoadFailureLayout dlflDataFailure;
    private ProgressLayout progDataBefore;
    private Context mContext;

    public TipsView(Context context) {
        super(context);
        this.mContext=context;
        init();
    }

    public TipsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        init();
    }


    public void setMyOnClickListener(OnClickListener l){
        dlflDataFailure.setRefreshClickListener(l);
    }


    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.view_tips_load, this);
        dlflDataFailure=(DataLoadFailureLayout)findViewById(R.id.dlfl_data_failure);
        progDataBefore=(ProgressLayout)findViewById(R.id.prog_data_before);
    }

    public void showPreData(){
        progDataBefore.setVisibility(View.VISIBLE);
        dlflDataFailure.setVisibility(View.GONE);
    }
    public void hideAll(){
        progDataBefore.setVisibility(View.GONE);
        dlflDataFailure.setVisibility(View.GONE);
    }
    public void showAfterDataError(){
        progDataBefore.setVisibility(View.GONE);
        dlflDataFailure.setVisibility(View.VISIBLE);
        dlflDataFailure.show();
    }
    public void showAfterNoData(){
        progDataBefore.setVisibility(View.GONE);
        dlflDataFailure.setVisibility(View.VISIBLE);
        dlflDataFailure.showNoDataTip();
    }
    public void showAfterNoData(String msg){
        progDataBefore.setVisibility(View.GONE);
        dlflDataFailure.setVisibility(View.VISIBLE);
        dlflDataFailure.showNoDataMsg(msg);
    }
    public void showErrorData(String msg){
        progDataBefore.setVisibility(View.GONE);
        dlflDataFailure.setVisibility(View.VISIBLE);
        dlflDataFailure.showErrorMsg(msg);
    }
    public void writeButtonMsg(String msg){
        dlflDataFailure.writeButtonMsg(msg);
    }

}
