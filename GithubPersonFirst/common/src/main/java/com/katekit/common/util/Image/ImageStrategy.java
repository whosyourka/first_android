package com.katekit.common.util.Image;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by 黄明灿 on 2018/1/4$ 9:20$.
 * Describe :
 */

public class ImageStrategy {
    private static Context mContext;
    public static void init(Context context) {
        mContext = context;
    }

    public static boolean showImageview(String path, ImageView imageView) {
        Glide.with(mContext).load(Uri.fromFile(new File(path))).into(imageView);
//        imageView.setImageBitmap(BitmapFactory.decodeFile(path));
//        Glide.with(context).load("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg").into(imageView);
        return true;
    }
    public static boolean showImageview(int resId, ImageView imageView) {
        Glide.with(mContext).load(resId).into(imageView);

//        Glide.with(context).load("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg").into(imageView);
        return true;
    }

    public static void showImageview(Bitmap bitmap, ImageView imageView) {
        Glide.with(mContext).load(bitmap).into(imageView);
    }
}
