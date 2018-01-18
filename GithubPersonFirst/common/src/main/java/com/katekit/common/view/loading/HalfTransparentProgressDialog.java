package com.katekit.common.view.loading;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.katekit.common.R;


/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband.view
 * Description：
 *
 * @author: huangmc
 * @date: 2015/9/9 14:03
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class HalfTransparentProgressDialog {
    private Context mContext;
    private Dialog mInProgressDialog;
    private TextView mInfoTextView;

    private String mInfo;

    public HalfTransparentProgressDialog(Context context, int resId){
        mContext = context;
        mInfo = mContext.getResources().getString(resId);
    }

    public HalfTransparentProgressDialog(Context context, String text){
        mContext = context;
        mInfo = text;
    }


    public Dialog getDialog(){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_half_transparent_loading, null);
        mInfoTextView = (TextView)view.findViewById(R.id.info);
        mInfoTextView.setText(mInfo);

        mInProgressDialog = new Dialog(mContext, R.style.dialog_style);
        mInProgressDialog.setCanceledOnTouchOutside(false);//点击屏幕内空白处不消失
        mInProgressDialog.setCancelable(false);
        mInProgressDialog.setContentView(view);

        return mInProgressDialog;
    }

    public void dismiss(){
        if (mInProgressDialog != null){
            mInProgressDialog.dismiss();
        }
    }

    public void show(){
        if (mInProgressDialog == null){
            mInProgressDialog = getDialog();
        }
        mInProgressDialog.show();
    }

    public void setInfoText(String text){
        if (mInfoTextView != null){
            mInfoTextView.setText(text);
            mInfoTextView.invalidate();
        }else{
            mInfo = text;
        }
    }
}
