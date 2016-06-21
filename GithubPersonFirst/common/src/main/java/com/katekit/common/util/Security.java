package com.katekit.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

public final class Security {
	/**
	 * 4
	 */
	public static final int FOUR = 4;
	/**
	 * 0xf
	 */
	public static final int TEMP = 0xf;

	/**
	 * Automatically generated method: Security
	 */
	private Security() {
	}

	/**
	 * 
	 * Description: 得到一个字符串加密后的结果 Implement: 1、… 2、… [参数列表，说明每个参数用途]
	 * 
	 * @param source
	 *            原字符串
	 * @return String MD5加密后的字符串
	 * @exception/throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static String getSecurity(String source) {
		return getSecurity(source.getBytes());
	}

	public static String getSecurity(byte[] data) {
		final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {

			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(data);
			final byte[] byteArr = mdTemp.digest();
			int length = byteArr.length;
			char[] str = new char[length << 1];
			int temp = 0;
			for (int i = 0; i < length; i++) {
				byte byte0 = byteArr[i];
				str[temp++] = hexDigits[byte0 >>> FOUR & TEMP];
				str[temp++] = hexDigits[byte0 & TEMP];
			}
			return new String(str);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static String getCrc32(byte[] data) {
		CRC32 crc = new CRC32();
		crc.update(data);
		return Long.toHexString(crc.getValue());
	}
}