package com.ffssabcloud.myblog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {
    public static final int SECOND = 0;
    public static final int MINUTE = 1;
    public static final int HOUR = 2;
    public static final int DAY = 3;
    public static final int WEEK = 4;
    public static final int MONTH = 5;
    public static final int YEAR = 6;
    
    public static int getUnixTime() {
        return (int) (System.currentTimeMillis() / 1000);
    }
    
    public static Date fmtStrDate(String date, String pattern) {
        if(StringUtils.isBlank(date)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static int getUnixTimeByDate(Date date) {
        return (int) (date.getTime() / 1000L);
    }
    
    public static Date addDate(Date date, int interval, long n) {
        long time = date.getTime() / 1000L;
        switch(interval) {
            case SECOND:
                time += n;
                break;
            case MINUTE:
                time += 60 * n;
                break;
            case HOUR:
                time += 3600 * n;
                break;
            case DAY:
                time += 86400 * n;
                break;
            case WEEK:
                time += 604800 * n;
                break;
            case MONTH:
                time += 2678400 * n;
                break;
            case YEAR:
                time += 31536000 * n;
        }
        Date date_ = new Date();
        date_.setTime(time * 1000L);
        
        return date_;
        
    }
}
