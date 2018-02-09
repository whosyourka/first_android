package com.katekit.common.net.Info.request;

import com.google.gson.JsonObject;
import com.landi.utillibrary.util.net.Info.BaseInfo;

/**
 * Created by »ÆÃ÷²Ó on 2017/10/13 8:50.
 */

public class BaseRequestInfo extends BaseInfo {
    private JsonObject requestJson = new JsonObject();
    private JsonObject dataJson = new JsonObject();
    private JsonObject pageJson = new JsonObject();

//    public BaseRequestInfo addRequestItem(String property, String value) {
//        requestJson.addProperty(property, value);
//        return this;
//    }
    public BaseRequestInfo addRequestCode(String value) {
        requestJson.addProperty("requestCode", value);
        return this;
    }
    public BaseRequestInfo addRequestSessionId(String value) {
        requestJson.addProperty("sessionId", value);
        return this;
    }
    public BaseRequestInfo addPageNum(String value) {
        pageJson.addProperty("curPageNum", value);
        return this;
    }
    public BaseRequestInfo addPageSize(String value) {
        pageJson.addProperty("pageSize", value);
        return this;
    }

    public BaseRequestInfo addDataItem(String property, String value) {
        dataJson.addProperty(property, value);
        return this;
    }

//    public Flowable<String> toStringFlowable() {
//        SendParams sendParams = new SendParams();
//        sendParams.add("requestParam", requestJson)
//                .add("pagingInfo", pageJson)
//                .add("data", dataJson);
//        return sendParams.toStringObservalbe();
//    }
}
