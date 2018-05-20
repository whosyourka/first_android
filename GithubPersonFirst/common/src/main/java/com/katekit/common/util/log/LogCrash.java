package com.katekit.common.util.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by 黄明灿 on 2018/3/13 9:28.
 * Describe :
 */
public class LogCrash implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();

        Writer result = new StringWriter();
        e.printStackTrace(new PrintWriter(result));
        LogUtil.e(result.toString());
    }
}
