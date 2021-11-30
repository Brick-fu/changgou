package com.changgou.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    public static String getDateTimeTo8(){
        return getDateTimeOfFormatter("yyyyMMdd");
    }

    public static String getDateTimeTo18(){
        return getDateTimeOfFormatter("yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateTimeTo14(){
        return getDateTimeOfFormatter("yyyyMMddHHmmss");
    }

    public static Date parseDateBy19(String date) throws ParseException{
        return parseDate("yyyy-MM-dd'T'HH:mm:ss",date);
    }

    public static Date parseDateBy18(String date) throws ParseException{
        return parseDate("yyyy-MM-dd HH:mm:ss",date);
    }

    public static String getDateTimeOfFormatter(String pattern){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(now);
    }

    public static Date parseDate(String pattern,String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(date);
    }

    public static String getDateTimeOfFormatter(String pattern,LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(dateTime);
    }

    public static LocalDateTime getCurrDateTime(){
        return LocalDateTime.now();
    }

    public static LocalDateTime getLocalDateTime(String date,String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(date,formatter);
    }
}
