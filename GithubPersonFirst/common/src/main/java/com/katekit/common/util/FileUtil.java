package com.katekit.common.util;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;

import com.katekit.common.MsgSetter.Constants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileUtil {

    public static boolean isExternalStorageExist() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        }
        return true;
    }

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

    /**
     * 从指定路径获取数据
     * @param fileName
     * @return
     */
    public static String readFileFromPaths(String fileName) {
        try {
            FileInputStream input = new FileInputStream(fileName);
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

    /**
     * 写入数据到制定路径
     */
    public static void writeFileToPath(String fileStr, String pathName) {
        File path = new File(pathName);
        if (!path.exists()) {
            path.delete();
        }
        try {
            FileOutputStream fout = new FileOutputStream(pathName);
            byte[] bytes = fileStr.getBytes();
            fout.write(bytes);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static String getPhotoPath(Application application) {
        return getAppPath(application);
    }
}
