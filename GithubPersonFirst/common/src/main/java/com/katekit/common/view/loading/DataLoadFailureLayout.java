package com.katekit.common.view.loading;

/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband.view
 * Description：
 *
 * @author: huangmc
 * @date: 2015/8/7 9:30
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.katekit.common.Constants;
import com.katekit.common.R;
import com.katekit.common.util.net.NetworkTypeUtil;


public class DataLoadFailureLayout extends LinearLayout {

    private TextView mDataErrorText;//信息

    private Button mRefreshButton;//刷新

    private Context context;


    public void setRefreshClickListener(OnClickListener l){
        mRefreshButton.setOnClickListener(l);
    }

    public DataLoadFailureLayout(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    public DataLoadFailureLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.data_load_fail, this, true);
        mDataErrorText = (TextView)view.findViewById(R.id.tv_data_error);
        mRefreshButton = (Button)view.findViewById(R.id.btn_refresh);
    }

    public void showNoDataTip(){
        mDataErrorText.setText("暂无数据");
        mRefreshButton.setVisibility(View.GONE);
    }
    public void showNoDataMsg(String msg){
        mDataErrorText.setText(msg);
        mRefreshButton.setVisibility(View.GONE);
    }
    public void showErrorMsg(String msg){
        mDataErrorText.setText(msg);
        mRefreshButton.setVisibility(View.VISIBLE);
    }
    public void writeButtonMsg(String msg){
        mRefreshButton.setText(msg);
    }

    public void show(){
        if (NetworkTypeUtil.getNetworkType(context) == NetworkTypeUtil.TYPE_NONE){
            mDataErrorText.setText(Constants.LOG_APP_NO_ERROR);
            mRefreshButton.setVisibility(View.VISIBLE);
        }else{
            mDataErrorText.setText(Constants.LOG_APP_OTHER_ERROR);
            mRefreshButton.setVisibility(View.VISIBLE);
        }
    }

}
