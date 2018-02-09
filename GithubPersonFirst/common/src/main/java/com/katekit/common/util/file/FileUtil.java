package com.katekit.common.util.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 黄明灿 on 2018/1/17 17:17.
 * Describe :
 */

public class FileUtil {

    /**
     * 复制单个文件
     * @param inStream
     * @param fileName
     */
    public static void copyFile(InputStream inStream, String fileName) {
        try {
            if (new File(fileName).exists()){
                new File(fileName).delete();
            }
            int bytesum = 0;
            int byteread = 0;
            if (inStream != null) { //文件存在时
                FileOutputStream fs = new FileOutputStream(fileName);
                byte[] buffer = new byte[1024];
                while((byteread = inStream.read(buffer)) != -1){
                    bytesum += byteread; //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                fs.close();
                inStream.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 得到一个文件夹下所有文件
     */
    public static List<String> getAllFileNameInFold(String fold_path) {
        List<String> file_paths = new ArrayList<String>();

        LinkedList<String> folderList = new LinkedList<String>();
        folderList.add(fold_path);
        while (folderList.size() > 0) {
            File file = new File(folderList.peekLast());
            folderList.removeLast();
            File[] files = file.listFiles();
            ArrayList<File> fileList = new ArrayList<File>();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    folderList.add(files[i].getPath());
                } else {
                    fileList.add(files[i]);
                }
            }
            for (File f : fileList) {
                file_paths.add(f.getAbsoluteFile().getPath());
            }
        }
        return file_paths;
    }



}
