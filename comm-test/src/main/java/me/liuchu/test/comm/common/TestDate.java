package me.liuchu.test.comm.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestDate {

    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static void testToday() throws ParseException {

        String format = "yyyy-MM-dd HH:mm:ss";
        String format2 = "yyyy-MM-dd";

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        SimpleDateFormat sdf2 = new SimpleDateFormat(format2);

        Date date = sdf.parse("2018-10-30 15:28:49");

        String date2Str = sdf2.format(new Date());

        Date date2 = sdf2.parse(date2Str);

        if (date.before(date2)) {
            System.out.println("BEFORE today");
        }

        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        form.parse(form.format(new Date()));
    }

    public static void test1970() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        Date date = sdf.parse("1970-01-01 08:00:00");
        Date zeroDateBefore1Sec = sdf.parse("1970-01-01 08:00:01");

        if (date.before(zeroDateBefore1Sec)) {
            System.out.println("WRONGGGGGGG");
        }
    }

    public static void testLocalDateTimeParse(){
        LocalDateTime time = LocalDateTime.parse("2018-12-01 00:01:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(time);
    }

    public static void testPlusMonth(){
        LocalDate base = LocalDate.parse("2018-11-30", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate now = LocalDate.now();

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());

    }

    public static void testBeginAndEndOfDay(){

        LocalDate today = LocalDate.now();

        LocalDateTime beginOfToday = LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 0,0,0,0);
        LocalDateTime endOfToday = LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 23,59,59,0);

        Date beginDate = Date.from(beginOfToday.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(endOfToday.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(beginDate);

        System.out.println(endDate);
    }

    public static void testLastMonth(LocalDate day){

        LocalDateTime endTemp;

        LocalDate today = LocalDate.now();

        //当月
        if (day.getYear() == today.getYear() && day.getMonthValue() == today.getMonthValue()) {
            endTemp = LocalDateTime.now();
        }{//以前月份
            endTemp = LocalDateTime.of(day.getYear(), day.getMonth(), day.getMonth().length(day.isLeapYear()),
                    23, 59, 59, 0);
        }

        Date res = Date.from(endTemp.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(res);
    }

    public static void testDateWithZone() throws ParseException {

        String date = "2019-01-03T11:41:20.000Z";
        date = date.replace("Z", " UTC");//是空格+UTC
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//格式化的表达式
        Date d = format.parse(date);

        System.out.println(d);
    }

    public static void main(String[] args) throws ParseException {
        //testToday();
        //test1970();
        //testLocalDateTimeParse();
        //testBeginAndEndOfDay();

        //testLastMonth(LocalDate.now().plusMonths(-2));

        //System.out.println("{\"contactSize\":142,\"platformName\":\"xiaozhuyoupin\",\"serialId\":481625}".length());

        testDateWithZone();
    }
}
