package com.katekit.common.view;

/**
 * Project Name：work1
 * Packagee Name：  com.katekit.nettest.presenter
 * Description：
 *
 * @author: huangmc
 * @date: 2016/3/3 15:46
 * Copyright (c) 2016年, Mr.huang . All Rights Reserved.
 */
public class MixDataView {

    // TODO: 2018/1/18 修改sub 
//    public Subscription mixDataAndView(Observable observable,IViewBinder myView){
//        myView.onBeforeData();
//        return observable
//                .subscribe(data->{
//                    myView.onNextData(data);
//                },error->{
//                    myView.onErrorData((Throwable)error);
//                    StringWriter sw = new StringWriter();
//                    ((Throwable)error).printStackTrace(new PrintWriter(sw, true));
//                    String str = sw.toString();
//                    System.out.println(str);
//                    Log.i("rxjava-error", str);
//
//                    myView.onAfterData();
//                },()->{
//                    myView.onCompleteData();
//                    myView.onAfterData();
//                });
//    }
}
