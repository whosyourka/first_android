package com.katekit.common.net.Ilogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 黄明灿 on 2017/10/11 10:07.
 */

public interface ILoginService {
//    @POST("handle")
//    Call<String> getLoginMsg(@Body String dataMsgInfo);
//    @POST("handle")
//    Call<String> verifyCode(@Body String data);
    @POST("handle")
    Call<String> defaultRequest(@Body String data);
}
