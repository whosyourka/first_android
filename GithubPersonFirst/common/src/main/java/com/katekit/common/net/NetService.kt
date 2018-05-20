package com.landi.utillibrary.util

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.katekit.common.net.IDownLoad.DownloadProgressInterceptor
import com.landi.utillibrary.util.net.Info.NetData
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by 黄明�? on 2017/6/8.
 */
object NetService {

    private val TIMEOUT_READ: Long = 30
    private val TIMEOUT_CONNECTION: Long = 30
    private val TIME_OUT_MAX = 30L

    val url = "";

    private var client = getOkhttp(DownloadProgressInterceptor(null))

    private fun getOkhttp(downloadProgressInterceptor: DownloadProgressInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(downloadProgressInterceptor)
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

    private var retrofit = getRetrofit(url,null)

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

//    init {
//        client = getOkhttp(DownloadProgressInterceptor(null))
//        retrofit = getRetrofit(url)
//    }
//
//
//    fun setNewNetObject(url: String): Boolean {
//        if (url.isNullOrEmpty()) {
//            retrofit = getRetrofit(NetService.url)
//            return true
//        } else {
//            return false
//        }
//    }

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
            subcribe.onError(Exception("request is null"))
        } else {
            request.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    when {
                        response == null -> subcribe.onError(Exception("response is null"))
                        response.body().isNullOrEmpty() -> subcribe.onError(Exception("response body is null"))
                        else -> {
                            try {
                                Log.d("NetService-response", response.body());
                                val netData: NetData<T> = NetData(response.body(), Gson().fromJson(response.body(), className.type))
                                when {
                                    netData.data == null -> subcribe.onError(Exception("netData.data is null"))
                                    else -> {
                                        subcribe.onNext(netData)
                                        subcribe.onComplete()
                                    }
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                                subcribe.onError(Exception("response data error"))
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<String>?, t: Throwable) {
                    subcribe.onError(t)
                }

            })
        }
    }, BackpressureStrategy.LATEST)
}