package com.py.common.utils;

/**分表帮助类
 * Created by jzl on 17/12/20.
 */
public class ShareTableUtil {

    /**
     * 分表方法
     */
    public static String generateTableName(String orignTableName, Long uid, Integer rule) {
        int res = (int) (uid/rule + 1);
        return new StringBuilder(orignTableName).append("_").append(res).toString();
    }

    public static void main(String[] args) {
        String name = generateTableName("user_voice_log", 2578L, 10000);
        System.out.println("name=" + name);
    }
}
