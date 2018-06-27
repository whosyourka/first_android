package com.katekit.common.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

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
    protected String TAG = this.getClass().getSimpleName();

    protected CompositeDisposable mCompositeSubscription=null;
    protected void bindSub(Disposable disposable){
        if (mCompositeSubscription==null ){
            mCompositeSubscription
                    = new CompositeDisposable();
        }
        mCompositeSubscription.add(disposable);
    }
    protected void unbindSub(){
        if (mCompositeSubscription!=null && !mCompositeSubscription.isDisposed()){
            mCompositeSubscription.clear();
            mCompositeSubscription=null;
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbindSub();
    }

}
