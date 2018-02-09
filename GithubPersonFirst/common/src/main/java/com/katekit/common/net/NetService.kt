package com.landi.utillibrary.util

import com.katekit.common.net.IDownLoad.DownloadProgressInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


/**
 * Created by 黄明�? on 2017/6/8.
 */
object NetService {

    private val TIMEOUT_READ: Long = 30
    private val TIMEOUT_CONNECTION: Long = 30
    private val TIME_OUT_MAX = 30L

    val TAG_RELOGIN: String = "relogin"
    val url = "";


    private var client = getOkhttp(DownloadProgressInterceptor(null))

    private fun getOkhttp(downloadProgressInterceptor: DownloadProgressInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor { chain ->
//                    if (chain != null) {
                        val request = chain.request()
                        val response = chain.proceed(request)
                        response
//                    } else {
//                        null
//                    }
                }
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

    private var retrofit = getRetrofit(url)

    private fun getRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(url)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

//    init {
//        client = getOkhttp(DownloadProgressInterceptor(null))
//        retrofit = getRetrofit(url)
//    }


    fun setNewNetObject(url: String): Boolean {
        if (url.isNullOrEmpty()) {
            retrofit = getRetrofit(NetService.url)
            return true
        } else {
            return false
        }
    }

    fun getNetObject(): Retrofit {
        return retrofit
    }

    fun getNetObject(url: String, downloadProgressInterceptor: DownloadProgressInterceptor): Retrofit {
        client = getOkhttp(downloadProgressInterceptor)
        setNewNetObject(url)
        return retrofit
    }


//    fun <T> exchangeGsonData(className: Class<T>, request: Call<String>?): Flowable<NetData<T>>? = Flowable.create({ subcribe ->
//
//        if (request == null) {
//            subcribe.onError(Exception("获取request为空"))
//        } else {
//            request.enqueue(object : Callback<String> {
//                override fun onResponse(call: Call<String>?, response: Response<String>?) {
//                    when {
//                        response == null -> subcribe.onError(Exception("获取response为空"))
//                        response.body().isNullOrEmpty() -> subcribe.onError(Exception("获取数据为空"))
//                        else -> {
//                            try {
//                                Log.d("NetService-response", response.body());
//                                val netData: NetData<T> = NetData(response.body(), Gson().fromJson(response.body(), className))
//                                when {
//                                    netData.data == null -> subcribe.onError(Exception("获取data为空"))
//                                    else -> {
//                                        try {
//                                            val defaultResponseInfo = Gson().fromJson(netData.orignData, DefaultResponseInfo::class.java)
//                                            if (defaultResponseInfo != null && "4".equals(defaultResponseInfo.responseState.code)) {
//                                                subcribe.onError(ReLoginException(TAG_RELOGIN))
//                                                return
//                                            }
//                                        } catch (e: Exception) {
//                                            e.printStackTrace()
//                                        }
//                                        subcribe.onNext(netData)
//                                        subcribe.onComplete()
//                                    }
//                                }
//                            } catch (e: Exception) {
//                                e.printStackTrace()
//                                subcribe.onError(Exception("获取data数据出现异常"))
//                            }
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<String>?, t: Throwable) {
//                    subcribe.onError(t)
//                }
//
//            })
//        }
//    }, BackpressureStrategy.LATEST)


}