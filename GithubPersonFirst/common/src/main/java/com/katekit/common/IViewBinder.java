package com.katekit.common.view;

/**
 * Project Name：work1
 * Packagee Name：  com.katekit.nettest.presenter
 * Description：
 *
 * @author: huangmc
 * @date: 2016/3/3 14:22
 * Copyright (c) 2016年, Mr.huang . All Rights Reserved.
 */
public interface IViewBinder {
     void onBeforeData();

     void onNextData(Object data);
     void onCompleteData();
     void onCompleteData(Object data);

     void onErrorData(Throwable error);

     void onAfterData();
}
