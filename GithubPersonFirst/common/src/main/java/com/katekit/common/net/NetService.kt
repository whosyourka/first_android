package com.landi.utillibrary.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.katekit.common.Constants
import com.katekit.common.exception.ReturnCodeException
import com.katekit.common.net.IDownLoad.DownloadProgressInterceptor
import com.katekit.common.util.log.LogUtil
import com.landi.utillibrary.util.net.Info.NetData
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by 黄明灿 on 2017/6/8.
 */
object NetService {

    private val TIMEOUT_READ: Long = 30
    private val TIMEOUT_CONNECTION: Long = 30
    private val TIME_OUT_MAX = 30L

    val url = "http://www.baidu.com";

    private var client = getOkhttp(DownloadProgressInterceptor(null))

    private fun getOkhttp(downloadProgressInterceptor: DownloadProgressInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(downloadProgressInterceptor)
                .addInterceptor(Interceptor {
                    LogUtil.d("%s:%s", Constants.NETSERVICE_URL,it.request().url())
                    it.proceed(it.request())
                })
                .retryOnConnectionFailure(true)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT_MAX, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor({
                    val request = it.request()
                    val response = it.proceed(request)
                    response
                })
                .build()
    }

    private var retrofit = getRetrofit(url, null)

    private fun getRetrofit(url: String, client: OkHttpClient?): Retrofit {
        if (client == null) {
            return Retrofit.Builder()
                    .client(this.client)
                    .baseUrl(url)
                    .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun setNewNetObject(url: String): Boolean {
        if (url.isNullOrEmpty()) {
            retrofit = getRetrofit(url, null)
            return true
        } else {
            return false
        }
    }

    fun getNewNetObject(url: String): Retrofit {
        return getRetrofit(url, null)
    }

    fun getNetObject(): Retrofit {
        return retrofit
    }

    fun getNetObject(url: String, downloadProgressInterceptor: DownloadProgressInterceptor): Retrofit {
        return getRetrofit(url, getOkhttp(downloadProgressInterceptor))
    }


    fun <T> exchangeGsonData(className: TypeToken<T>, request: Call<String>?): Flowable<NetData<T>>? = Flowable.create({ subcribe ->
        if (request == null) {
            subcribe.onError(ReturnCodeException("request is null"))
        } else {
            request.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    when {
                        response == null -> subcribe.onError(ReturnCodeException("response is null"))
                        response.body().isNullOrEmpty() -> subcribe.onError(ReturnCodeException("response body is null"))
                        else -> {
                            LogUtil.d("%s:%s",Constants.NETSERVICE_RESPONSE, response.body());
                            val netData: NetData<T> = NetData(response.body(), Gson().fromJson(response.body(), className.type))
                            if (netData.data == null) {
                                subcribe.onError(ReturnCodeException("netData.data is null"))
                            } else {
                                //可处理逻辑，一般处理returnCode等,成功则继续，否则就
                                subcribe.onNext(netData)
                                subcribe.onComplete()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<String>?, t: Throwable) {
                    // http通讯错误
                    subcribe.onError(t)
                }

            })
        }
    }, BackpressureStrategy.LATEST)

}