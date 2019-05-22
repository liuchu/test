package me.liuchu.test.comm.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDateFormator {


    public static Date getDate(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static int daysBetween(Date sDate, Date bDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long betweenDays = 0;
        try {
            Date s = sdf.parse(sdf.format(sDate));
            Date b = sdf.parse(sdf.format(bDate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(s);
            long time1 = cal.getTimeInMillis();
            cal.setTime(b);
            long time2 = cal.getTimeInMillis();
            betweenDays = (time2 - time1) / (1000 * 3600 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(String.valueOf(betweenDays));
    }

    public static void main(String[] args) {
        //Date date = getDate("2018-09-20 00:00:01","yyyy-MM-dd HH:mm:ss");
        //System.out.println("date:"+date.toString());

        daysBetween(null,new Date());
    }
}
