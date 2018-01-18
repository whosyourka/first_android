package com.katekit.common.net.Info.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by »ÆÃ÷²Ó on 2017/10/23 9:54.
 */

public class PagingInfo {

    /**
     * totalCount : 9
     * pageSize : 20
     * curPageNum : 1
     * totalPage : 1
     */

    @SerializedName("totalCount")
    private int totalCount;
    @SerializedName("pageSize")
    private int pageSize;
    @SerializedName("curPageNum")
    private int curPageNum;
    @SerializedName("totalPage")
    private int totalPage;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurPageNum() {
        return curPageNum;
    }

    public void setCurPageNum(int curPageNum) {
        this.curPageNum = curPageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
