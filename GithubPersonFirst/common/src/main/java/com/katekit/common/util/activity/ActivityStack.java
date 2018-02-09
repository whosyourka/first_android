package com.katekit.common.util.activity;

import android.app.Activity;

import com.katekit.common.acitivity.BaseActivity;

import java.util.Stack;


/**
 * Project Name：workplace
 * Packagee Name：  com.chinanetcenter.broadband.util
 * Description：
 *
 * @author: huangmc
 * @date: 2015/10/12 14:46
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class ActivityStack {
    private static Stack<BaseActivity> activityStack;
    private static ActivityStack instance;

    private ActivityStack() {
    }

    public static ActivityStack getActivityStack() {
        if (instance == null) {
            instance = new ActivityStack();
        }
        return instance;
    }

    public void popActivity() {
        if (activityStack.size() <= 0){
            return;
        }
        Activity activity = activityStack.lastElement();
        if (activity != null) {
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }

    public void clearActivity() {
        for (int i = activityStack.size() - 1; i >= 0; i--) {
            Activity actvitiy = activityStack.get(i);
            popActivity(actvitiy);
        }
    }

    public void popActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }

    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    public void pushActivity(BaseActivity activity) {
        if (activityStack == null) {
            activityStack = new Stack<BaseActivity>();
        }
        activityStack.add(activity);
    }

    public void popAllActivityExceptOne(Class<?> cls) {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            if (activity.getClass().equals(cls)) {
                break;
            }
            popActivity(activity);
        }
    }

    public void finishActivity(int times) {
        int size = activityStack.size();
        int time = times;
        while (time > 0) {
            Activity activity = activityStack.get(size - times);
            if (activity != null) {
                activity.finish();
                activityStack.remove(activity);
                activity = null;
            }
            time--;
        }

    }

    // 只是remove了activity
    public void removeActivityFromStatck(Activity activity){
        if (activity != null) {
            activityStack.remove(activity);
            activity = null;
        }
    }

    public int size(){
        if (activityStack != null){
            return activityStack.size();
        }
        return 0;
    }
}
