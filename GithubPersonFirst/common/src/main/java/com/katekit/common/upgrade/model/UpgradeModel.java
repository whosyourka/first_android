package com.katekit.common.upgrade.model;

import com.landi.utillibrary.net.IDownLoad.DownloadProgressInterceptor;
import com.landi.utillibrary.net.IDownLoad.DownloadProgressResponseBody;
import com.landi.utillibrary.net.NetDataCenter;
import com.landi.utillibrary.upgrade.contract.UpgradeContract;
import com.landi.utillibrary.util.NetService;
import com.landi.utillibrary.util.net.Info.NetData;

import io.reactivex.Flowable;

/**
 * Created by »ÆÃ÷²Ó on 2017/11/14 17:01.
 */

public class UpgradeModel implements UpgradeContract.Model {
    @Override
    public Flowable<NetData<DownloadProgressResponseBody>> downloadApp(String url, DownloadProgressInterceptor downloadProgressInterceptor) {
        return NetService.INSTANCE.exchangeGsonData(DownloadProgressResponseBody.class,
                NetDataCenter.getDownloadService(url, downloadProgressInterceptor).download(url));
    }
}
