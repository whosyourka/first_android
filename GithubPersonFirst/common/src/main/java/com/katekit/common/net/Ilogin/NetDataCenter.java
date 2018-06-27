package com.katekit.common.net.Ilogin;

import com.google.gson.reflect.TypeToken;
import com.landi.utillibrary.util.NetService;
import com.landi.utillibrary.util.net.Info.NetData;

import io.reactivex.Flowable;

/**
 * Created by ������ on 2017/10/11 10:07.
 */

public class NetDataCenter {
    public static Flowable<NetData<String>> getLoginService(String data) {
        return NetService.INSTANCE.exchangeGsonData(new TypeToken<String>() {
        }, NetService.INSTANCE.getNetObject().create(ILoginService.class).defaultRequest(data));
    }
}
