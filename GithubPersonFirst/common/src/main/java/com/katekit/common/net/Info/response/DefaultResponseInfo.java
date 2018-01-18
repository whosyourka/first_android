package com.katekit.common.net.Info.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by »ÆÃ÷²Ó on 2017/10/12 15:23.
 */

public class DefaultResponseInfo {
    @SerializedName("responseState")
    private ResponseState responseState;

    public ResponseState getResponseState() {
        return responseState;
    }

    public void setResponseState(ResponseState responseState) {
        this.responseState = responseState;
    }
}
