package com.katekit.common.util.sendDataProcessing;


import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * Project Name£ºwork1
 * Packagee Name£º  com.chinanetcenter.broadband.module.net
 * Description£º
 *
 * @author: huangmc
 * @date: 2015/12/22 14:26
 * Copyright (c) 2015Äê, Mr.huang . All Rights Reserved.
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
                return new ToJsonRxUtil().paraToJsonString(hashMap);
            }
        });
    }

    public Flowable<JSONObject> toJsonObservalbe() {
        return Flowable.just(hashMap).map(new Function<HashMap<String, Object>, JSONObject>() {
            @Override
            public JSONObject apply(@NonNull HashMap<String, Object> hashMap) throws Exception {
                return new ToJsonRxUtil().paraToJsonJson(hashMap);
            }
        });
    }
}
