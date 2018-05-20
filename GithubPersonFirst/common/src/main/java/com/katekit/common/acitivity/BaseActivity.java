package com.katekit.common.acitivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Project Name：work1
 * Packagee Name：  com.katekit.nettest
 * Description：
 *
 * @author: huangmc
 * @date: 2016/3/2 10:09
 * Copyright (c) 2016年, Mr.huang . All Rights Reserved.
 */
public class BaseActivity extends AppCompatActivity {
    protected String TAG = this.getClass().getSimpleName();

    private CompositeDisposable mCompositeSubscription=null;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbindSub();
    }
}
