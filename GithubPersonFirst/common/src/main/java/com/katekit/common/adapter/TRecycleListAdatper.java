package com.katekit.common.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Project Name：workplace
 * Packagee Name：  com.chinanetcenter.broadband.adapter
 * Description：
 *
 * @author: huangmc
 * @date: 2015/11/4 19:14
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class TRecycleListAdatper<T> extends RecyclerView.Adapter {
    protected ArrayList<T> mDatas;
    protected Context mContext;
    public TRecycleListAdatper(ArrayList<T> mDatas,Context mContext){
        this.mDatas=mDatas;
        this.mContext=mContext;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }
}
