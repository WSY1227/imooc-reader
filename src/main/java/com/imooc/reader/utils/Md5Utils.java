package com.imooc.reader.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ClassName: Md5Utils
 * @Description: md5工具类
 * @author: XU
 * @date: 2022年09月02日 15:30
 **/

public class Md5Utils {
    /**
     * MD5加密
     *
     * @param source 原值
     * @param salt   盐值
     * @return
     */
    public static String md5Digest(String source, Integer salt) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + salt);
        }
        String target = new String(chars);
        String md5 = DigestUtils.md5Hex(target);
        return md5;
    }
}
