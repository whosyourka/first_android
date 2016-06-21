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
    public ReturnCodeException() {
    }

    public ReturnCodeException(String message) {
        super(message);
        msg = message;
    }

    @Override
    public String toString() {
        return msg;
    }
}