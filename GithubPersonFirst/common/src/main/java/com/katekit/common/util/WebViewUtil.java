package com.katekit.common.util;

/**
 * Project Name：workplace
 * Packagee Name：  com.chinanetcenter.broadband.util
 * Description：
 *
 * @author: huangmc
 * @date: 2015/10/16 15:34
 * Copyright (c) 2015年, Mr.huang . All Rights Reserved.
 */
public class WebViewUtil {
    //适应webview4.4
    public static String getWebViewWithImageFit(String content) {

        // content is the content of the HTML or XML.
        String stringToAdd = "width=\"100%\" ";

        // Create a StringBuilder to insert string in the middle of content.
        StringBuilder sb = new StringBuilder(content);

        int i = 0;
        int cont = 0;

        // Check for the "src" substring, if it exists, take the index where
        // it appears and insert the stringToAdd there, then increment a counter
        // because the string gets altered and you should sum the length of the inserted substring
        while (i != -1) {
            i = content.indexOf("src", i + 1);
            if (i != -1) sb.insert(i + (cont * stringToAdd.length()), stringToAdd);
            ++cont;
        }
        return sb.toString().replaceAll("width\\s*:\\s*[0-9]+([.]{1}[0-9]+){0,1}px;", "");

    }
}
