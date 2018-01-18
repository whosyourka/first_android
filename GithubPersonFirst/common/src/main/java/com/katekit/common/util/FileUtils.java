/************************************************************
 *	版权�?�?  (c)2013,   蔡志�?<p>	
 *  文件名称	：FileUtils.java<p>
 *
 *  创建时间	�?2015-8-27 下午1:44:10 
 *  当前版本号：v1.0
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
        throw new Exception("�޷�ɾ��֮ǰ��apk�������Ծ��޷������ļ���");
    }

    /**
     * �������� : writeIntoNewFile
     * �������� :
     * ����������ֵ˵����
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
                    throw new Exception("�޷�ɾ��֮ǰ��apk�������Ծ��޷������ļ���");
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
