package com.katekit.common.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by 黄明灿 on 2018/1/16 18:49.
 * Describe :
 */

public class FileContentUtil {
    public static void appendInfoToFile(String fileName, String info) {
        File file = new File(fileName);
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter osw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file, true);
            osw = new OutputStreamWriter(fileOutputStream, "UTF-8");
            osw.write(info);
            osw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static String getFileString(String path) {
        try {
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder stringBuilder = new StringBuilder();
            byte[] buffer = new byte[1024];
            int length = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line+"\n");
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void clearInfoForFile(String fileName) {
        FileWriter fileWriter = null;
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
