package com.katekit.common.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Project Name：NetUser
 * Packagee Name：  com.chinanetcenter.netuser.adapter
 * Description：
 *
 * @author: huangmc
 * @date: 2015/7/23 9:48
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public abstract class TListAdapter<T> extends BaseAdapter {
    protected ArrayList<T> mDatas;
    protected Context mContext;

    public TListAdapter(Context mContext, ArrayList<T> mDatas) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }
    public void setData(ArrayList<T> mDatas){
        if (mDatas==null ||  mDatas.size()==0){
            return;
        }
        this.mDatas=mDatas;
        this.notifyDataSetChanged();
    }
    public ArrayList<T> getData(){
        return mDatas;
    }
    @Override
    public int getCount() {
        return mDatas==null?0:mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas==null?null:mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    abstract public View getView(int position, View convertView, ViewGroup parent);

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater
//                    .from(mContext)
//                    .inflate(R.layout.adapter_broadband_package_item, parent, false);
//        }
//
//        ImageView headview=ViewHolderUtil.get(convertView, R.id.iv_broadband_item);
//        ImageLoader.getInstance().displayImage(mDatas.get(position).icon, headview, NetUserApp.imageOptions);
//
//        return convertView;
//    }

}
