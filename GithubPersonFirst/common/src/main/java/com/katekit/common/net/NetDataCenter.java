package com.katekit.common.net;

import com.landi.utillibrary.net.IDownLoad.DownloadProgressInterceptor;
import com.landi.utillibrary.net.IDownLoad.IDownloadService;
import com.landi.utillibrary.net.Ilogin.ILoginService;
import com.landi.utillibrary.util.NetService;

/**
 * Created by »ÆÃ÷²Ó on 2017/10/11 10:07.
 */

public class NetDataCenter {
    public static ILoginService getLoginService() {
        return NetService.INSTANCE.getNetObject().create(ILoginService.class);
    }

    public static IDownloadService getDownloadService(String url, DownloadProgressInterceptor downloadProgressInterceptor) {
        return NetService.INSTANCE.getNetObject(url,downloadProgressInterceptor).create(IDownloadService.class);
    }
}
