package com.katekit.common.compoment.upgrade.contract;

/**
 * Created by 黄明灿 on 2017/11/14 17:01.
 */

public interface UpgradeContract {
    interface Model {


//        Flowable<NetData<DownloadProgressResponseBody>> downloadApp(String url, DownloadProgressInterceptor downloadProgressInterceptor);
    }

    public interface SearchVersionView {
//        void needUpgrade();
//        void needNotUpgrade();
    }

    public interface UpgradeView  {
//        void update(long bytesRead, long contentLength, boolean done);
//
//        void downloadSueecss(String path);
    }


    interface Presenter {
//        void searchNewVersion(SearchVersionView listener);
//
//
//        void startUpgrade(String url, UpgradeView upgradeView);
    }
}
