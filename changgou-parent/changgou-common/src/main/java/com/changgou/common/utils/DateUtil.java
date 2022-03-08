package com.changgou.common.utils;

import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.common.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    public static String getDateTimeTo8(){
        return getDateTimeOfFormatter("yyyyMMdd");
    }

    public static String getDateTimeTo18(){
        return getDateTimeOfFormatter("yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateTimeTo14(){
        return getDateTimeOfFormatter("yyyyMMddHHmmss");
    }

    public static Date parseDateBy19(String date) {
        return parseDate("yyyy-MM-dd'T'HH:mm:ss",date);
    }

    public static Date parseDateBy14(String date) {
        return parseDate("yyyyMMddHHmmss",date);
    }

    public static Date parseDateBy18(String date) {
        return parseDate("yyyy-MM-dd HH:mm:ss",date);
    }

    public static String getDateTimeOfFormatter(String pattern){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(now);
    }

    public static Date parseDate(String pattern,String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            LOGGER.error("时间解析失败！",e);
            throw new BizException(StatusCodeEnum.TIME_PARSE_ERROR);
        }
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
