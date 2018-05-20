package com.katekit.common.util.log;

import android.util.Log;

import com.katekit.common.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by 黄明灿 on 2018/3/13 9:28.
 * Describe :
 */
public class LogUtil {
    public static void initLog() {
        FormatStrategy formatStrategyDefault = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(3)         // (Optional) How many method line to show. Default 2
                .methodOffset(6)        // (Optional) Hides internal method calls up to offset. Default 5  主要是获取位置
                .logStrategy(new LogStrategy() {
                    private int last;
                    @Override
                    public void log(int priority, String tag, String message) {
                        Log.println(priority, randomKey() + tag, message);
                    }

                    private String randomKey() {
                        int random = (int) (10 * Math.random());
                        if (random == last) {
                            random = (random + 1) % 10;
                        }
                        last = random;
                        return String.valueOf(random);
                    }
                }) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("LogUtil")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategyDefault) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });


        FormatStrategy diskStrategy = CsvFormatStrategy.newBuilder()
                .logStrategy(new LogStrategy() {
                    private int last;
                    @Override
                    public void log(int priority, String tag, String message) {
                        Log.println(priority, randomKey() + tag, message);
                    }

                    private String randomKey() {
                        int random = (int) (10 * Math.random());
                        if (random == last) {
                            random = (random + 1) % 10;
                        }
                        last = random;
                        return String.valueOf(random);
                    }
                }) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("LogUtil disk")
                .build();
        Logger.addLogAdapter(new DiskLogAdapter(diskStrategy) {

            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });

    }

    public static void d(String tag, String msg) {
        Logger.d(tag,msg);
    }

    public static void d(String msg) {
        Logger.d(msg);
    }

    public static void i(String tag, String msg) {
        Logger.i(tag,msg);
    }

    public static void i(String msg) {
        Logger.i(msg);
    }

}
