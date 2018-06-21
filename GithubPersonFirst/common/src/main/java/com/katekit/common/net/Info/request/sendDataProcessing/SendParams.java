package com.katekit.common.net.Info.request.sendDataProcessing;


import com.google.gson.Gson;
import com.katekit.common.Constants;
import com.katekit.common.util.log.LogUtil;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * Project Name：work1
 * Packagee Name：  com.chinanetcenter.broadband.module.net
 * Description：
 *
 * @author: huangmc
 * @date: 2015/12/22 14:26
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class SendParams {
    HashMap<String, Object> hashMap = new HashMap<>();

    public SendParams add(String name, Object object) {
        if (object != null) {
            hashMap.put(name, object);
        }
        return this;
    }

    public Flowable<String> toStringObservalbe() {
        return Flowable.just(hashMap).map(new Function<HashMap<String, Object>, String>() {
            @Override
            public String apply(@NonNull HashMap<String, Object> hashMap) throws Exception {
                return paraToJsonString(hashMap);
            }
        });
    }

    public Flowable<JSONObject> toJsonObservalbe() {
        return Flowable.just(hashMap).map(new Function<HashMap<String, Object>, JSONObject>() {
            @Override
            public JSONObject apply(@NonNull HashMap<String, Object> hashMap) throws Exception {
                return  paraToJsonJson(hashMap);
            }
        });
    }

    public String paraToJsonString(HashMap<String,Object> hashMap){
        String params=new Gson().toJson(hashMap);
        showlog(params.toString());
        return params;
    }
    public JSONObject paraToJsonJson(HashMap<String,Object> hashMap){
        JSONObject jsonObject=new JSONObject(hashMap);
        showlog(jsonObject.toString());
        return jsonObject;
    }

    public void showlog(String log){
        LogUtil.d(Constants.NETSERVICE_REQUEST,log);
    }
}
