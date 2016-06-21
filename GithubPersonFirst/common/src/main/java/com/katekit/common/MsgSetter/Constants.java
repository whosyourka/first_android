package com.katekit.common.MsgSetter;

import android.os.Environment;

/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband
 * Description：
 *
 * @author: caill
 * @date: 2015/11/6 18:27
 * Copyright (c) 2015年, All Rights Reserved.
 */
public class Constants {
    public static final String PHOTO_FILE_SUFFIX = ".jpg"; //照片保存文件后缀名
    public static final String APP_FILE_PATH = Environment.getExternalStorageDirectory()  +"/Constants/"; // SD卡上面目录，有sd情况下存放所有相关的文件

    //log

    public static final String LOG_START_TIME="rxjava-start:TIME";
    public static final String LOG_START_DIVIDE="rxjava-start:DIVIDE";

    public static final String LOG_START_SUBMIT="rxjava-start:sendParam";
    public static final String LOG_START_URL="rxjava-start:URL";

    public static final String LOG_START_MSG="rxjava-start-Msg";
    public static final String LOG_START_CODE="rxjava-start-Code";
    public static final String LOG_START_TYPE="rxjava-start-Type";
    public static final String LOG_START_CONTENT="rxjava-start-Content";

    public static final String LOG_LAST_ERROR="rxjava-last-error";
    public static final String LOG_LAST_SUCCESS="rxjava-last-success";

    public static final String LOG_LAST_DIVIDE="rxjava-last:DIVIDE";



    public static final String LOG_APP_ERROR="app异常,请重启";
    public static final String LOG_APP_NO_ERROR="请检测您的网络是否连接";
    public static final String LOG_APP_OTHER_ERROR ="好像出了点问题，请稍后重试";


}
