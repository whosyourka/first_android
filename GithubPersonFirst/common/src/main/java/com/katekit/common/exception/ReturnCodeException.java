package com.katekit.common.exception;

/**
 * Project Name：trunk
 * Packagee Name：  com.chinanetcenter.broadband.Exception
 * Description：
 *
 * @author: huangmc
 * @date: 2015/9/11 16:19
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class ReturnCodeException extends Exception {
    private String msg;
    private String code;
    public ReturnCodeException() {
    }

    public ReturnCodeException(String message) {
        super(message);
        this.msg = message;
    }
    public ReturnCodeException(String message,String code) {
        super(message);
        this.msg = message;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return msg;
    }
}