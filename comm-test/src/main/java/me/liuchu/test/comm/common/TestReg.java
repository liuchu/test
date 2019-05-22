package me.liuchu.test.comm.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {

    public static void main(String[] args) {
        String str = "7天内身份证关联设备数：4";

        String pat = "(\\d+$)";

        Matcher matcher = Pattern.compile(pat).matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
