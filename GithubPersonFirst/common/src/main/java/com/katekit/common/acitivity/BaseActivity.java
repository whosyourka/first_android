package com.katekit.common.acitivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import org.reactivestreams.Subscription;


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


//    protected CompositeSubscription mCompositeSubscription=null;
    protected void bindSub(Subscription subscription){
//        if (mCompositeSubscription==null ){
//            mCompositeSubscription
//                    = new CompositeSubscription();
//        }
//        mCompositeSubscription.add(subscription);
    }
    protected void unbindSub(){
//        if (mCompositeSubscription!=null && !mCompositeSubscription.isUnsubscribed()){
//            mCompositeSubscription.unsubscribe();
//            mCompositeSubscription=null;
//        }
    }

//    protected CompositeSubscription mSpecialOneRecycle=null;
    public void bindOneSub(Subscription subscription){
//        if (mSpecialOneRecycle==null ){
//            mSpecialOneRecycle
//                    = new CompositeSubscription();
//        }
//        mSpecialOneRecycle.add(subscription);
    }
    public void unbindOneSub(){
//        if (mSpecialOneRecycle!=null && !mSpecialOneRecycle.isUnsubscribed()){
//            mSpecialOneRecycle.unsubscribe();
//            mSpecialOneRecycle=null;
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
//        button.setOnClickListener(v -> {
//            ToastUtil.show(this,"haha");
//        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbindSub();
    }
}
