package com.katekit.common.compoment.upgrade.view;

/**
 * Created by 黄明灿 on 2017/11/14 14:19.
 */

public class UpgradeDialog {
//    private UpgradeContract.Presenter mPresenter = new UpgradePresenter();
//
//    public void startUpgrade(final Context context, boolean isShowLoading) {
//        if (isShowLoading) {
//            LodingLayout.show(context, "正在查询是否有新版本");
//        }
//        mPresenter.searchNewVersion(new UpgradeContract.SearchVersionView() {
//
//            @Override
//            public void needUpgrade() {
//                CommonBaseDialogUtil.showChooseDialogMsg(context, "升级", "您有新版本，是否升级？", new CommonBaseDialogUtil.ChooseListener() {
//                    @Override
//                    public void chooseYes() {
//                        mPresenter.startUpgrade("www.baidu.com", new UpgradeContract.UpgradeView() {
//                            @Override
//                            public void update(long bytesRead, long contentLength, boolean done) {
//
//                            }
//
//                            @Override
//                            public void downloadSueecss(String path) {
//                                // 通过Intent安装APK文件
//                                Intent intent = new Intent(Intent.ACTION_VIEW);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                intent.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
//                                context.startActivity(intent);
//                            }
//
//                            @Override
//                            public void onError(String string) {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable t) {
//
//                            }
//
//                            @Override
//                            public void onCompleted() {
//
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void chooseNo() {
//
//                    }
//                });
//            }
//
//            @Override
//            public void needNotUpgrade() {
//                CommonBaseDialogUtil.showComfirmDialogMsg(context, "升级", "您已经是最新版本了", new CommonBaseDialogUtil.ChooseListener() {
//                    @Override
//                    public void chooseYes() {
//
//                    }
//
//                    @Override
//                    public void chooseNo() {
//
//                    }
//                });
//            }
//
//            @Override
//            public void onError(String string) {
//                ToastUtil.show(context, string);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                t.printStackTrace();
//                ToastUtil.show(context, t.toString());
//            }
//
//            @Override
//            public void onCompleted() {
//                LodingLayout.hide();
//            }
//        });
//
//
//    }


}
