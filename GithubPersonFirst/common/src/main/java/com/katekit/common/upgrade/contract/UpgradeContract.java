package com.katekit.common.upgrade.contract;

import com.landi.utillibrary.BaseViewInterface;
import com.landi.utillibrary.net.IDownLoad.DownloadProgressInterceptor;
import com.landi.utillibrary.net.IDownLoad.DownloadProgressResponseBody;
import com.landi.utillibrary.util.net.Info.NetData;

import io.reactivex.Flowable;

/**
 * Created by »ÆÃ÷²Ó on 2017/11/14 17:01.
 */

public interface UpgradeContract {
    interface Model {


        Flowable<NetData<DownloadProgressResponseBody>> downloadApp(String url, DownloadProgressInterceptor downloadProgressInterceptor);
    }

    public interface SearchVersionView extends BaseViewInterface {
        void needUpgrade();
        void needNotUpgrade();
    }

    public interface UpgradeView extends BaseViewInterface {
        void update(long bytesRead, long contentLength, boolean done);

        void downloadSueecss(String path);
    }


    interface Presenter {
        void searchNewVersion(SearchVersionView listener);


        void startUpgrade(String url, UpgradeView upgradeView);
    }
}
