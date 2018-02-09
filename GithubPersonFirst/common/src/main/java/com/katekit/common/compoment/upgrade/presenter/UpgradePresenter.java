package com.katekit.common.compoment.upgrade.presenter;

import com.katekit.common.compoment.upgrade.contract.UpgradeContract;

/**
 * Created by 黄明灿 on 2017/11/14 17:01.
 */

public class UpgradePresenter implements UpgradeContract.Presenter {
//    private UpgradeContract.Model model = new UpgradeModel();
//
//    @Override
//    public void searchNewVersion(final UpgradeContract.SearchVersionView listener) {
////        return new BaseRequestInfo().addRequestCode("1001")
////                .addDataItem("phone", phone)
////                .addDataItem("password", pwd)
////                .addDataItem("deviceCode", UniqueId.getIMEI(UnionpayApplication.getInstance()))
////                .addDataItem("code", code)
////                .toStringFlowable()
////                .flatMap(new Function<String, Flowable<NetData<LoginResponseInfo>>>() {
////                    @Override
////                    public Flowable<NetData<LoginResponseInfo>> apply(@NonNull String data) throws Exception {
////                        return NetService.INSTANCE.exchangeGsonData(NetDataCenter.getLoginService().defaultRequest(data), LoginResponseInfo.class);
////                    }
////                });
//        Flowable.timer(3, TimeUnit.SECONDS)
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        listener.needUpgrade();
//                        listener.onCompleted();
//                    }
//                });
//    }
//
//    @Override
//    public void startUpgrade(String url, final UpgradeContract.UpgradeView upgradeView) {
//        model.downloadApp(url, new DownloadProgressInterceptor(new DownloadProgressResponseBody.DownloadProgressListener() {
//            @Override
//            public void update(long bytesRead, long contentLength, boolean done) {
//                upgradeView.update(bytesRead, contentLength, done);
//            }
//        }))
//                .map(new Function<NetData<DownloadProgressResponseBody>, InputStream>() {
//                    @Override
//                    public InputStream apply(NetData<DownloadProgressResponseBody> downloadProgressResponseBodyNetData) throws Exception {
//                        return downloadProgressResponseBodyNetData.getData().byteStream();
//                    }
//                })
//                .map(new Function<InputStream, String>() {
//                    @Override
//                    public String apply(InputStream inputStream) throws Exception {
//                        try {
//                            if (!FileUtils.writeIntoNewFile(inputStream, FileUtils.APK_FILE_NAME)) {
//                                throw new Exception("保存文件到本机失败!");
//                            }
//                            return FileUtils.getNewFilePath(FileUtils.APK_FILE_NAME);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            throw new Exception(e.getMessage());
//                        }
//                    }
//                })
//                .compose(RxUtil.<String>applySchedulers())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String path) throws Exception {
//                        upgradeView.downloadSueecss(path);
//                        upgradeView.onCompleted();
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        upgradeView.onError(throwable);
//                    }
//                });
//    }


}
