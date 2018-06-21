package com.katekit.common.net.IDownLoad;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by 黄明灿 on 2017/11/15 9:27.
 */

public class DownloadProgressInterceptor implements Interceptor {

    private DownloadProgressResponseBody.DownloadProgressListener listener;

    public DownloadProgressInterceptor(DownloadProgressResponseBody.DownloadProgressListener listener) {
        this.listener = listener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        return originalResponse.newBuilder()
                .body(new DownloadProgressResponseBody(originalResponse.body(), listener))
                .build();
    }
}