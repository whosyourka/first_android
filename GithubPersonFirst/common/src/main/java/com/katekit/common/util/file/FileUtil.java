package com.katekit.common.util.file;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;

import com.katekit.common.Constants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

public class FileUtil {



    public static String readFileFromAssets(Context context, String fileName) {
        try {
            if (null == context || null == fileName)
                return null;
            AssetManager am = context.getAssets();
            InputStream input = am.open(fileName);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = input.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }
            output.close();
            input.close();
            return output.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    // 如果有SD卡则创建目录。没有则选择data下的file目录
    public static String getAppPath(Application application) {
        if (FileUtil.isExternalStorageExist()) {
            File path = new File(Constants.APP_FILE_PATH);
            if (!path.exists()) {
                path.mkdirs();
            }
            return Constants.APP_FILE_PATH;
        } else {
            return application.getFilesDir().getAbsolutePath();
        }
    }
    public static boolean isExternalStorageExist() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        }
        return true;
    }

}
