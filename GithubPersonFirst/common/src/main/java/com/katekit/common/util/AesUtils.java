package com.katekit.common.util;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Project Name：NetUser
 * Packagee Name：  com.chinanetcenter.broadband.util
 * Description：
 *
 * @author: huangmc
 * @date: 2015/7/28 15:58
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class AesUtils {
    private static final String AES = "AES";
    private static final String ENCODE = "UTF-8";

    private static final String IV = "12345678abcdefgh";
    private static final int KEY_SIZE = 16;
    public static final String KEY = "56212235226886758978225025933009171679";

    public static final String CIPHER_ALGORITHM="AES/CBC/PKCS5Padding";

    private AesUtils(){}

    public static String encryptBase64(String content, String password){
        byte keyPtr[] = new byte[KEY_SIZE];
        try {
            byte passPtr[] = password.getBytes(ENCODE);

            for (int i = 0; i < KEY_SIZE; i++) {
                if (i < passPtr.length){
                    keyPtr[i] = passPtr[i];
                }
                else {
                    keyPtr[i] = 0;
                }
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyPtr, AES);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(IV.getBytes(ENCODE)));
//            return Base64.encodeBase64String(cipher.doFinal(content.getBytes(ENCODE)));
            return Base64.encodeToString(cipher.doFinal(content.getBytes(ENCODE)), Base64.NO_WRAP);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decryptBase64(String content, String password){
        byte keyPtr[] = new byte[KEY_SIZE];
        try {
            byte passPtr[] = password.getBytes(ENCODE);
            for (int i = 0; i < KEY_SIZE; i++) {
                if (i < passPtr.length){
                    keyPtr[i] = passPtr[i];
                }
                else {
                    keyPtr[i] = 0;
                }
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyPtr, AES);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,new IvParameterSpec(IV.getBytes(ENCODE)));
            byte[] base64 = Base64.decode(content, Base64.NO_WRAP);
            return new String(cipher.doFinal(base64));//, Charset.forName(ENCODE));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
