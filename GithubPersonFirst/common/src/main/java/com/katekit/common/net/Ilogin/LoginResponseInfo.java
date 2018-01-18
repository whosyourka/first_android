package com.katekit.common.net.Ilogin;

import com.google.gson.annotations.SerializedName;
import com.landi.utillibrary.net.Info.response.ResponseState;

import java.util.List;

/**
 * Created by ª∆√˜≤” on 2017/10/10 16:10.
 */
public class LoginResponseInfo {

    /**
     * responseState : {"code":"0"}
     * data : [{"isNeedCode":"0","name":"√˚≥∆","userType":"1","storeInfoList":[{"storeNo":"100000000000066","storeName":"µÍ∆Ã66","merchantNo":"402000076310000"},
     * {"storeNo":"100000000000062","storeName":"µÍ∆Ã62","merchantNo":"402000076310000"}]}]
     */

    @SerializedName("responseState")
    private ResponseState responseState;
    @SerializedName("data")
    private List<Data> data;

    public ResponseState getResponseState() {
        return responseState;
    }

    public void setResponseState(ResponseState responseState) {
        this.responseState = responseState;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }


    public static class Data {
        /**
         * isNeedCode : 0
         * name : √˚≥∆
         * userType : 1
         * storeInfoList : [{"storeNo":"100000000000066","storeName":"µÍ∆Ã66","merchantNo":"402000076310000"},{"storeNo":"100000000000062","storeName":"µÍ∆Ã62",
         * "merchantNo":"402000076310000"}]
         */

        @SerializedName("sessionId")
        private String sessionId;
        @SerializedName("aliPushId")
        private String aliPushId;
        @SerializedName("updatePwdFlag")
        private String updatePwdFlag;
        @SerializedName("isNeedCode")
        private String isNeedCode;
        @SerializedName("name")
        private String name;
        @SerializedName("userType")
        private String userType;
        @SerializedName("storeInfoList")
        private List<StoreInfoList> storeInfoList;

        public String getAliPushId() {
            return aliPushId;
        }

        public void setAliPushId(String aliPushId) {
            this.aliPushId = aliPushId;
        }

        public String getUpdatePwdFlag() {
            return updatePwdFlag;
        }

        public void setUpdatePwdFlag(String updatePwdFlag) {
            this.updatePwdFlag = updatePwdFlag;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getIsNeedCode() {
            return isNeedCode;
        }

        public void setIsNeedCode(String isNeedCode) {
            this.isNeedCode = isNeedCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public List<StoreInfoList> getStoreInfoList() {
            return storeInfoList;
        }

        public void setStoreInfoList(List<StoreInfoList> storeInfoList) {
            this.storeInfoList = storeInfoList;
        }

        public static class StoreInfoList {
            /**
             * storeNo : 100000000000066
             * storeName : µÍ∆Ã66
             * merchantNo : 402000076310000
             */

            @SerializedName("storeNo")
            private String storeNo;
            @SerializedName("storeName")
            private String storeName;
            @SerializedName("merchantNo")
            private String merchantNo;

            public String getStoreNo() {
                return storeNo;
            }

            public void setStoreNo(String storeNo) {
                this.storeNo = storeNo;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            public String getMerchantNo() {
                return merchantNo;
            }

            public void setMerchantNo(String merchantNo) {
                this.merchantNo = merchantNo;
            }
        }
    }
}
