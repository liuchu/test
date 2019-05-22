package me.liuchu.test.comm.mvel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TestDate {

    public static void test(){
        LocalDate localDate = LocalDate.now();
        Date date = new Date();

        System.out.println(localDate.toString());

        System.out.println(date);

    }

    public static void test2(){
        LocalDate localDate = LocalDate.now().plusDays(-1);
        Date date = getDate(LocalDate.now().plusDays(-1).toString(),"yyyy-MM-dd");

        System.out.println(localDate.toString());

        System.out.println(date);
    }

    public static Date getDate(String dateString, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        //test();
        //test2();

        Set<Integer> set  = new HashSet<>();

        set.add(1234);
        set.add(1111);
        set.add(1222);

        set.remove(1234);

        set.forEach(System.out::println);

    }
}
