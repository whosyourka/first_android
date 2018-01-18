/************************************************************
 *	鐗堟潈鎵?鏈?  (c)2013,   钄″織鏋?<p>	
 *  鏂囦欢鍚嶇О	锛欶ileUtils.java<p>
 *
 *  鍒涘缓鏃堕棿	锛?2015-8-27 涓嬪崍1:44:10 
 *  褰撳墠鐗堟湰鍙凤細v1.0
 ************************************************************/
package com.katekit.common.util;

import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileUtils {

    public static String APK_FILE_NAME = "yellowbank.apk";


    public static String getNewFilePath(String name) throws Exception {
        File file = new File(Environment.getExternalStorageDirectory(), name);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        throw new Exception("无法删除之前的apk包，所以就无法保存文件。");
    }

    /**
     * 函数名称 : writeIntoNewFile
     * 功能描述 :
     * 参数及返回值说明：
     *
     * @param is
     * @return
     * @throws Exception
     */
    public static boolean writeIntoNewFile(InputStream is, String name) throws Exception {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), name);
            if (file.exists()) {
                if (file.delete()) {
                    file.createNewFile();
                } else {
                    throw new Exception("无法删除之前的apk包，所以就无法保存文件。");
                }
            }
            fos = new FileOutputStream(file);
            bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                fos.flush();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                bis.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
