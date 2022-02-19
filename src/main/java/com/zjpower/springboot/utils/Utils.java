package com.zjpower.springboot.utils;

import java.util.Random;

public class Utils {
    public static String getRandomString(int minLength, int maxLength) {
        Random random = new Random();
        int number = random.nextInt(maxLength - minLength) + minLength;
        return getRandomString(number);
    }

    public static String getRandomString(int length) {
        // 定义一个字符串（A-Z，a-z，0-9）；
        // ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789
        String str = "abcdefghijklmnopqrstuvwxyz";
        //由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
