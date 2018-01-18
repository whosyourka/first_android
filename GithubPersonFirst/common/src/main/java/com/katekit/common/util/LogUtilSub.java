package com.katekit.common.util;


import com.katekit.common.MsgSetter.Constants;
import com.katekit.common.exception.ReturnCodeException;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Project Name：workplace1
 * Packagee Name：  com.chinanetcenter.broadband.util
 * Description：
 *
 * @author: huangmc
 * @date: 2015/11/10 16:05
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class LogUtilSub<T>  {


//    @Override
    public void onCompleted() {
        LogUtil.i(Constants.LOG_LAST_DIVIDE, "-----------------------------------------------");
    }

//    @Override
     public void onError(Throwable e) {
        showError(e);
        onCompleted();
    }

//    @Override
    public void onNext(T t) {
        showSuccess(t);
    }

    public void showError(Throwable e) {
        e.printStackTrace();
        LogUtil.i(Constants.LOG_LAST_ERROR, "errorMsg--:" + e.toString());
//        if (e instanceof RetrofitError) {
//            RetrofitError retrofitError=(RetrofitError)e;
//            switch (retrofitError.getKind()) {
//                case NETWORK:
//                    LogUtil.i(Constants.LOG_LAST_ERROR, "errorshow--网络错误（NETWORK）");
//                    break;
//                case CONVERSION:
//                    LogUtil.i(Constants.LOG_LAST_ERROR, "errorshow--输入问题（CONVERSION）");
//                    break;
//                case HTTP:
//                    LogUtil.i(Constants.LOG_LAST_ERROR, "errorshow--http（HTTP）");
//                    break;
//                case UNEXPECTED:
//                    LogUtil.i(Constants.LOG_LAST_ERROR, "errorshow--未知错误（UNEXPECTED）:"+retrofitError.toString());
//                    break;
//            }
//            if (retrofitError.getResponse()!=null) {
//                LogUtil.i(Constants.LOG_LAST_ERROR, "errorDetail：错误代码" + retrofitError.getResponse().getStatus()
//                        + "  错误原因:" + retrofitError.getResponse().getReason());
//            }
//        } else
        if (e instanceof ReturnCodeException) {
            LogUtil.i(Constants.LOG_LAST_ERROR, "errorshow--返回信息的错误：" + e.toString());
        } else {
            LogUtil.i(Constants.LOG_LAST_ERROR, "errorshow--其他错误：具体看下面！");
        }
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        String str = sw.toString();
        LogUtil.i(Constants.LOG_LAST_ERROR, "errorLocation--printStackTrace：" + str);
    }

    public void showSuccess(T t) {
        LogUtil.i(Constants.LOG_LAST_SUCCESS, "success-onNext");
    }

}
