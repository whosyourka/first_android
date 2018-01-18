package com.katekit.common.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.landi.utillibrary.R;
import com.landi.utillibrary.util.px2dp.DensityUtil;

/**
 * Project Name£º work
 * Packagee Name£º com.landicorp.android.view
 * Description£º
 *
 * @author: huangmc
 * @date: 11:15
 * Copyright (c) 2015Äê, Mr.huang . All Rights Reserved.
 */
public class CommonBaseDialogUtil {

    public interface ChooseListener {
        void chooseYes();

        void chooseNo();
    }


    public static BaseDialog showComfirmDialogMsg(final Context ctx, String title, String content, final ChooseListener chooseListener) {
        BaseDialog dialog = new BaseDialogBuilder(ctx)
                .setTitle(title)
                .setMessage(content)
                .setSingleButton(R.string.action_confirm, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (chooseListener != null) {
                            chooseListener.chooseYes();
                        }

                        // notify to refresh OrderList activity
                    }
                })
                .create();
        dialog.show();
        return dialog;
    }

    public static BaseDialog showChooseDialogMsg(final Context ctx, String title, String content, final ChooseListener chooseListener) {
        return showChooseDialogMsg(ctx, title, content, "·ñ", "ÊÇ", chooseListener);
    }

    public static BaseDialog showChooseDialogMsg(final Context ctx, String title, String content, String cancelName, String ensureName, final ChooseListener
            chooseListener) {
        BaseDialog dialog;
        dialog = new BaseDialogBuilder(ctx)
                .setTitle(title)
                .setMessage(content)
                .setNegativeButton(cancelName, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (chooseListener != null) {
                            chooseListener.chooseNo();
                        }

                        // notify to refresh OrderList activity
                    }
                })
                .setPositiveButton(ensureName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (chooseListener != null) {
                            chooseListener.chooseYes();
                        }

                    }
                })
                .create();
        dialog.show();
        return dialog;
    }
    public static BaseDialog showCustomViewMsg(final Context ctx, String title, View view, String cancelName, String ensureName, final ChooseListener chooseListener) {
        BaseDialog dialog;

        dialog = new BaseDialogBuilder(ctx)
                .setTitle(title)
                .setContentView(view)
                .setNegativeButton(cancelName, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (chooseListener != null) {
                            chooseListener.chooseNo();
                        }

                        // notify to refresh OrderList activity
                    }
                })
                .setPositiveButton(ensureName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
                        if (chooseListener != null) {
                            chooseListener.chooseYes();
                        }

                    }
                })
                .create();
        dialog.show();
        DensityUtil.setMax(ctx,dialog);
        return dialog;
    }
}
