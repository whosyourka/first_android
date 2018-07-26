package com.katekit.common.acitivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.katekit.common.util.log.LogUtil;

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
    protected String TAG = this.getClass().getSimpleName() + " ";

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
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG  +"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG  +"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d(TAG  +"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG  +"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(TAG  +"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(TAG  +"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG  +"onDestroy");
        unbindSub();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.d(TAG  +"onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.d(TAG  +"onRestoreInstanceState");
        
    }
}
