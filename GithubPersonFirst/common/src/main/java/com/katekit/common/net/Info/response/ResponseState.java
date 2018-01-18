package com.katekit.common.net.Info.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by »ÆÃ÷²Ó on 2017/10/12 15:36.
 */

public class ResponseState {
    /**
     * code : 0
     * "description": "ÕËºÅÎ´×¢²á",
     */

    @SerializedName("code")
    private String code;
    @SerializedName("description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
