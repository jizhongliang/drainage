/**
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.py.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author jinlilong
 * @version $Id: DateUtil.java, v 0.1 2017年12月13日 下午5:29:00 jinlilong Exp $
 */
public class DateUtil {

    // 默认日期格式
    public static final String DATE_DEFAULT_FORMAT     = "yyyy-MM-dd";

    // 默认时间格式
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**  */
    public static final String TIME_DEFAULT_FORMAT     = "HH:mm:ss";

    /**
     * 日期格式化
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        if (format == null) {
            format = DATE_DEFAULT_FORMAT;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 日期格式化
     * @param date
     * @param format
     * @return
     */
    public static String formatDateTime(Date date, String format) {
        if (format == null) {
            format = DATETIME_DEFAULT_FORMAT;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 
     * @return
     */
    public static String getCurrentDate() {
        return formatDate(new Date(), DATETIME_DEFAULT_FORMAT);
    }

}
