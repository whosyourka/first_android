package com.katekit.common.util;

import android.text.TextUtils;

import com.katekit.common.MsgSetter.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband
 * Description：
 *
 * @author: huangmc
 * @date: 2015/8/21 11:40
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class ParameUtil {
    public String paraToJsonString(String[] strings){
        JSONObject jsonObject = new JSONObject();
        try {
            int temCount = strings.length / 2;
            for (int i = 0; i < temCount; i++) {
                if (!TextUtils.isEmpty(strings[2 * i + 1])) {
                    jsonObject.put(strings[2 * i], strings[2 * i + 1]);
                }
            }
            showlog(jsonObject.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

//    public String paraToJsonString(HashMap<String,Object> hashMap){
//        String params=new Gson().toJson(hashMap);
//        showlog(params.toString());
//        return params;
//    }
    public JSONObject paraToJsonJson(HashMap<String,Object> hashMap){

        JSONObject jsonObject=new JSONObject(hashMap);
        showlog(jsonObject.toString());
        return jsonObject;
    }

    public void showlog(String  log){

        LogUtil.i(Constants.LOG_START_SUBMIT, log);
    }

}
