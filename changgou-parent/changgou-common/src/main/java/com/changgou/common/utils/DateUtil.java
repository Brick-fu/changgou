package com.changgou.common.utils;

import com.changgou.common.enums.StatusCodeEnum;
import com.changgou.common.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    public static final String PATTERN_10 = "yyyyMMddHH";
    public static final String PATTERN_8 = "yyyyMMdd";
    public static final String PATTERN_19 = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_14 = "yyyyMMddHHmmss";
    public static final String PATTERN_21 = "yyyy-MM-dd'T'HH:mm:ss";

    public static String getDateTimeTo8(){
        return getDateTimeOfFormatter(PATTERN_8);
    }

    public static String getDateTimeTo10(){
        return getDateTimeOfFormatter(PATTERN_10);
    }

    public static String getDateTimeTo19(){
        return getDateTimeOfFormatter(PATTERN_19);
    }

    public static String getDateTimeTo14(){
        return getDateTimeOfFormatter(PATTERN_14);
    }

    public static Date parseDateBy21(String date) {
        return parseDate(PATTERN_21,date);
    }

    public static Date parseDateBy14(String date) {
        return parseDate(PATTERN_14,date);
    }

    public static Date parseDateBy10(String date) {
        return parseDate(PATTERN_10,date);
    }

    public static Date parseDateBy19(String date) {
        return parseDate(PATTERN_19,date);
    }

    public static String formatDateTo10(Date date){
        return data2str(date,PATTERN_10);
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

    /***
     * 时间转成yyyyMMddHH
     * @param date
     * @param pattern
     * @return
     */
    public static String data2str(Date date, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
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

    /***
     * 获取时间菜单
     * @return
     */
    public static List<Date> getDateMenus(){
        //定义一个List<Date>集合，存储所有时间段
        List<Date> dates = getDates(12);
        //判断当前时间属于哪个时间范围
        Date now = new Date();
        for (Date cdate : dates) {
            //开始时间<=当前时间<开始时间+2小时
            if(cdate.getTime()<=now.getTime() && now.getTime()<addDateHour(cdate,2).getTime()){
                now = cdate;
                break;
            }
        }

        //当前需要显示的时间菜单
        List<Date> dateMenus = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            dateMenus.add(addDateHour(now,i*2));
        }
        return dateMenus;
    }

    /***
     * 指定时间往后N个时间间隔
     * @param hours
     * @return
     */
    public static List<Date> getDates(int hours) {
        List<Date> dates = new ArrayList<Date>();
        //循环12次
        Date date = toDayStartHour(new Date()); //凌晨
        for (int i = 0; i <hours ; i++) {
            //每次递增2小时,将每次递增的时间存入到List<Date>集合中
            dates.add(addDateHour(date,i*2));
        }
        return dates;
    }

    /***
     * 获取指定日期的凌晨
     * @return
     */
    public static Date toDayStartHour(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /***
     * 时间增加N分钟
     * @param date
     * @param minutes
     * @return
     */
    public static Date addDateMinutes(Date date,int minutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);// 24小时制
        date = calendar.getTime();
        return date;
    }

    /***
     * 时间递增N小时
     * @param hour
     * @return
     */
    public static Date addDateHour(Date date,int hour){//Jota-time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hour);// 24小时制
        date = calendar.getTime();
        return date;
    }


}
