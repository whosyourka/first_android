package com.katekit.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;

import java.net.URLEncoder;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DesUtil {
	public static final String MD5 = "2989d4f8dcda393d1c1ca3c021f0cb10"; // 本地数据加密存储用到的key
	
	public static final String NET_3DES_KEY = "80dee591a993ea01e51a766134f7827d"; // 网络数据传输加密用到的key

	private final static String iv = "01234567";

    private final static String DES_CHARSET = "utf-8";  

	private static String secureKey = "";

	private static String elementsTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	private static String mapTable = "z9xwvu8srqp7nmlk6ihgf5dcbaZ4XWVU3SRQP2NMLK1IHGF0DCBAEJOTYejoty";

	public static void init(Context context) {
		secureKey = Security.getSecurity(MD5 + context.getPackageName());
	}
  
    public static String encrypt(String data)throws Exception{
		return encode(getSecureKey(), data);
    }
    
    public static String encrypt(int data)throws Exception{
    	return  encrypt(String.valueOf(data));
    }
    
    public static String encrypt(long data)throws Exception{
    	return encrypt(String.valueOf(data));
    }
    
    public static String encrypt(boolean data)throws Exception{
    	return encrypt(String.valueOf(data));
    }
    
	public static String encrypt(float data) throws Exception {
		return encrypt(String.valueOf(data));
	}

    public static String decrypt(String encrypted)throws Exception{
		return decode(getSecureKey(), encrypted);
    }
    
	private static String getSecureKey() {
		return secureKey;
	}

    /** 
     * 3DES加密 
     * @param secretKey 密钥 
     * @param plainText 普通文本 
     * @return 
     * @throws Exception  
     */  
	public static String encode(String secretKey, String plainText) throws Exception {
		if (plainText == null){
			return "";
		}
		Cipher cipher = getCBCCipher(Cipher.ENCRYPT_MODE, secretKey.getBytes());
		byte[] encryptData = cipher.doFinal(plainText.getBytes(DES_CHARSET));
		return Base64.encodeToString(encryptData, Base64.NO_WRAP);
	}
  
    /** 
     * 3DES解密 
     * @param secretKey   密钥
     * @param encryptText 加密文本 
     * @return 
     * @throws Exception 
     */  
	public static String decode(String secretKey, String encryptText) throws Exception {
		if (encryptText == null){
			return "";
		}
		Cipher cipher = getCBCCipher(Cipher.DECRYPT_MODE, secretKey.getBytes());
		byte[] decryptData = cipher.doFinal(Base64.decode(encryptText, Base64.NO_WRAP));
        return new String(decryptData, DES_CHARSET);  
	}

	private static Cipher getCBCCipher(int opmode, byte[] secretKey) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(opmode, deskey, ips);
		return cipher;
	}
	public static String urlEncode(String plainText) {
		try {
			return URLEncoder.encode(plainText, DES_CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Imsi 映射
	 * @param str
	 * @return
	 */
	public static String imsiencryption(String str) {
		String new_str = "";
		if(!TextUtils.isEmpty(str)) {
			for (int i = 0; i < str.length(); i++) {
				char temp = str.charAt(i);
				int idx = elementsTable.indexOf(temp);
				new_str = new_str + mapTable.charAt(idx);
			}
		}
		return new_str;
	}

	public static String imsidecryption(String str) {
		String new_str = "";
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			int idx = mapTable.indexOf(temp);
			new_str = new_str + elementsTable.charAt(idx);
		}

		return new_str;
	}
}
