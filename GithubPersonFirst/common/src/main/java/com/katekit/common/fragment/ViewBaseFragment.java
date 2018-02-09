package com.katekit.common.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.katekit.common.Constants;
import com.katekit.common.exception.ReturnCodeException;
import com.katekit.common.util.log.LogUtilSub;
import com.katekit.common.util.listener.PreventDoubleClickListener;
import com.katekit.common.util.ToastUtil;
import com.katekit.common.view.loading.HalfTransparentProgressDialog;
import com.katekit.common.view.loading.TipsView;
import com.katekit.common.ViewBinderImpl;

/**
 * Project Name：workplace
 * Packagee Name：  com.chinanetcenter.broadband.fragment
 * Description：
 *
 * @author: huangmc
 * @date: 2015/10/14 10:15
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class ViewBaseFragment extends BaseFragment {
    protected String TAG = this.getClass().getSimpleName();

    //获取extras
    protected Bundle getMyExtras() {
        return getActivity().getIntent().getExtras();
    }

    //结束
    protected void finishThis() {
        getActivity().finish();
    }
    protected void finishOKThis() {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    //处理刷新
    protected TipsView mTipsView;  // 用于提示加载和网络

    protected void setRefresh() {
    }

    protected void addTipsView(ViewGroup mainGroup) {
        if (mTipsView == null) {
            mTipsView = new TipsView(getActivity());
            mTipsView.setMyOnClickListener(new PreventDoubleClickListener() {
                @Override
                public void onMyOnClick(View v) {
                    setRefresh();
                }
            });

            ViewGroup viewGroup = mainGroup;
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup != null) {
                viewGroup.addView(mTipsView, params);
            }
        }
    }

    protected void showLoading() {
        if (mTipsView != null) {
            mTipsView.showPreData();
        }
    }

    protected void showNetError() {
        if (mTipsView != null) {
            mTipsView.showAfterDataError();
        }
    }

    protected void showNoData() {
        if (mTipsView != null) {
            mTipsView.showAfterNoData();
        }
    }

    protected void showNoDataMsg(String msg) {
        if (mTipsView != null) {
            if (!TextUtils.isEmpty(msg)) {
                mTipsView.showAfterNoData(msg);
            }
        }
    }

    protected void showErrorMsg(String msg) {
        if (mTipsView != null) {
            if (!TextUtils.isEmpty(msg)) {
                mTipsView.showErrorData(msg);
            }
        }
    }

    protected void writeButtonMsg(String msg) {
        if (mTipsView != null) {
            if (!TextUtils.isEmpty(msg)) {
                mTipsView.writeButtonMsg(msg);
            }
        }
    }

    protected void hideAll() {
        if (mTipsView != null) {
            mTipsView.hideAll();
        }
    }

    //处理发送数据前刷新
    private HalfTransparentProgressDialog progressDialog;

    protected void showPreLoading() {
        showPreLoading("正在刷新中...");
    }

    protected void showPreLoading(String content) {
        if (progressDialog == null) {
            progressDialog = new HalfTransparentProgressDialog(getActivity(), content);
            progressDialog.setInfoText(content);
        } else {
            progressDialog.setInfoText(content);
        }
        progressDialog.show();
    }

    protected void hidePreLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    //处理错误
    public void CatchThrowableToast(Throwable e) {
        if (CatchThrowableToast(getActivity(), e)) {
            ToastUtil.show(getActivity(), Constants.LOG_APP_ERROR);
        }
    }

    public static Boolean CatchThrowableToast(Activity context, Throwable e) {
        if (context == null) {
            return false;
        }
//        if (e instanceof Retrofit.Builder.) {
//            if (NetworkTypeUtil.getNetworkType(context) == NetworkTypeUtil.TYPE_NONE) {
//                ToastUtil.showToast(context, Constants.LOG_APP_NO_ERROR);
//            } else {
//                ToastUtil.showToast(context, Constants.LOG_APP_OTHER_ERROR);
//            }
//        } else
        if (e instanceof ReturnCodeException) {
            ToastUtil.show(context, e.toString());
        } else {
            return true;
        }
        return false;
    }

    protected void CatchThrowableView(Throwable e) {

        if (getActivity() == null) {
            return;
        }
//        if (e instanceof RetrofitError) {
//            showNetError();
//        } else
        if (e instanceof ReturnCodeException) {
            showErrorMsg(e.toString());
        } else {
            showErrorMsg(Constants.LOG_APP_ERROR);
        }
    }


    //show the msg in the fragment
    public class ShowMsgSub<T> extends LogUtilSub<T> {


        @Override
        public void onError(Throwable e) {
            super.onError(e);
            hidePreLoading();
            hideAll();
            CatchThrowableView(e);
        }

        @Override
        public void onNext(T t) {
            super.onNext(t);
            hidePreLoading();
            hideAll();
        }
    }

    //use toast to show the msg  and  its for the outside loading
    public class ToastMsgSub<T> extends LogUtilSub<T> {


        @Override
        public void onError(Throwable e) {
            super.onError(e);
            hidePreLoading();
            hideAll();
            CatchThrowableToast(e);
        }

        @Override
        public void onNext(T t) {
            super.onNext(t);
            hidePreLoading();
            hideAll();
        }


    }//show the msg in the fragment

    protected final int PRE_LOADING_NONE = 0;
    protected final int PRE_LOADING_TRANSPARENT = 1;
    protected final int PRE_LOADING_WHITE = 2;
    protected final int AFTER_LOADING_NONE = 0;
    protected final int AFTER_LOADING_TOAST = 1;
    protected final int AFTER_LOADING_SHOW_VIEW = 2;

    public class ShowMsgBinder extends ViewBinderImpl {

        private int dealWithPreLoading = 0;
        private int dealWithAfterLoading = 0;

        public ShowMsgBinder() {

        }

        public ShowMsgBinder(int beforeLoading, int afterLoading) {
            dealWithAfterLoading = afterLoading;
            dealWithPreLoading = beforeLoading;
        }

        @Override
        public void onBeforeData() {
            switch (dealWithPreLoading) {
                case PRE_LOADING_NONE:
                    break;
                case PRE_LOADING_TRANSPARENT:
                    showPreLoading();
                    break;
                case PRE_LOADING_WHITE:
                    showLoading();
                    break;
            }

        }

        @Override
        public void onErrorData(Throwable error) {
            switch (dealWithAfterLoading) {
                case AFTER_LOADING_NONE:
                    break;
                case AFTER_LOADING_TOAST:
                    CatchThrowableToast(error);
                    break;
                case AFTER_LOADING_SHOW_VIEW:
                    CatchThrowableView(error);
                    break;
            }

        }

        @Override
        public void onAfterData() {
            hidePreLoading();
            hideAll();
        }
    }




}
