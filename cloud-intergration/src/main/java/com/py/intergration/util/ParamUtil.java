package com.py.intergration.util;


/**
 * 参数校验帮助类
 * Created by jzl on 17/2/28.
 */
public class ParamUtil {
    /**
     * 不为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj){
        if (!"".equals(obj) && obj != null){
            return false;
        }else {
            return true;
        }

    }
    /**
     * 检测字符串是否为空(null,"","null")
     *
     * @param s
     * @return
     */
    public static String nullToStr(String s) {
        if(s == null || "null".equals(s))
            s = "";
        return s;
    }
    public static void main(String[] args) {
        Object s = null;
        boolean b = isEmpty(s);
        System.out.println(b);
        System.out.println(isEmpty(1));
    }
}
