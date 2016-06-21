package com.katekit.common.fragment;

import android.support.v4.app.Fragment;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Project Name：NetUser
 * Packagee Name：  com.chinanetcenter.netuser.fragment
 * Description：
 *
 * @author: huangmc
 * @date: 2015/7/21 16:13
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class BaseFragment extends Fragment {
    protected CompositeSubscription mCompositeSubscription= new CompositeSubscription();

    protected void bindSub(Subscription subscription){
        if (mCompositeSubscription==null ){
            mCompositeSubscription
                    = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }
    protected void unbindSub(){
        if (mCompositeSubscription!=null && !mCompositeSubscription.isUnsubscribed()){
            mCompositeSubscription.unsubscribe();
            mCompositeSubscription=null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbindSub();
    }




    protected CompositeSubscription mSpecialOneRecycle=null;

    public void bindOneSub(Subscription subscription){
        if (mSpecialOneRecycle==null ){
            mSpecialOneRecycle
                    = new CompositeSubscription();
        }
        mSpecialOneRecycle.add(subscription);
    }
    public void unbindOneSub(){
        if (mSpecialOneRecycle!=null && !mSpecialOneRecycle.isUnsubscribed()){
            mSpecialOneRecycle.unsubscribe();
            mSpecialOneRecycle=null;
        }
    }

}
