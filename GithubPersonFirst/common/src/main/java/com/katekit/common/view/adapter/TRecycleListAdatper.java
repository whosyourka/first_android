package com.katekit.common.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.katekit.common.util.listener.RecyclerItemClickListener;

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
public abstract class TRecycleListAdatper<T, R extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<R> {
    private ArrayList<T> mDatas;
    private Context mContext;
    private RecyclerItemClickListener.OnItemClickListener mOnRecyclerItemClickListener;

    public void setmDatas(ArrayList<T> mDatas) {
        this.mDatas = mDatas;
    }

    public ArrayList<T> getmDatas() {
        return mDatas;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public RecyclerItemClickListener.OnItemClickListener getmOnRecyclerItemClickListener() {
        return mOnRecyclerItemClickListener;
    }

    public void setmOnRecyclerItemClickListener(RecyclerItemClickListener.OnItemClickListener mOnRecyclerItemClickListener) {
        this.mOnRecyclerItemClickListener = mOnRecyclerItemClickListener;
    }

    public TRecycleListAdatper(ArrayList<T> mDatas, Context mContext, RecyclerItemClickListener.OnItemClickListener mOnRecyclerItemClickListener) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mOnRecyclerItemClickListener = mOnRecyclerItemClickListener;
    }

    @Override
    public abstract R onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(R holder, int position);

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }
}
