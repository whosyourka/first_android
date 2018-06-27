package com.katekit.common.net.IDownLoad;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by 黄明灿 on 2017/11/15 10:03.
 */

public interface IDownloadService {
    @Streaming
    @GET
    Call<String> download(@Url String url);
}
