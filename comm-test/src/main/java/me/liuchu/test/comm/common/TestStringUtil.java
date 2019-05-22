package me.liuchu.test.comm.common;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TestStringUtil {

    public static void test(){
        String str1 = "";

        if (StringUtils.isEmpty(str1)) {
            System.out.println("str1 is empty");
        }
        if (StringUtils.isBlank(str1)) {
            System.out.println("str1 is blank");
        }

        String str2 = null;

        if (StringUtils.isEmpty(str2)) {
            System.out.println("str2 is empty");
        }
        if (StringUtils.isBlank(str2)) {
            System.out.println("str2 is blank");
        }

    }

    public static void testStr(){

        String num = "123456789";

        System.out.println(num.substring(0,4));

        ImmutableSet<Integer> sets = new ImmutableSet.Builder<Integer>().build();
    }

    public static void testString(){

        String constantStr1 = "hey";
        String constantStr2 = "man";
        String constantStr3 = "hey"+"man";

        String variableStr1 = new String("hey");
        String variableStr2 = constantStr1 + constantStr2;

        System.out.println(constantStr1 == "hey"); //should be true
        System.out.println(variableStr1 == "hey"); //should be false

        System.out.println(constantStr3 == "heyman"); //should be true
        System.out.println(variableStr2 == "heyman"); //should be false

        System.out.println( (constantStr1+constantStr2) == (constantStr1+constantStr2)); //should be false

    }

    public static void testSubString(){
        String str = "123456";
        int a = Integer.valueOf(str.substring(0, str.indexOf("ex")));
        System.out.println(a);
    }

    public static String getSortParams(Map<String, String> params) {
        SortedMap<String, String> map = new TreeMap<>();
        Iterator iter = params.keySet().iterator();

        while (iter.hasNext()) {
            String key = (String) iter.next();
            map.put(key, params.get(key));
        }

        Set<String> keySet = map.keySet();
        iter = keySet.iterator();

        String str;
        String key;
        String value;
        for (str = ""; iter.hasNext(); str = str + value + "|") {
            key = (String) iter.next();
            value = map.get(key);
        }

        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }

        return str;
    }

    public static void main(String[] args) {
        //TestStringUtil.testString();
        //String str = "http://rong360-raw-jxl.oss-cn-hangzhou.aliyuncs.com/filesfiles/2018-12-05/2018-12-05-15-04-47213916252756r360_mobile_detail.zip?Expires=1575099547&OSSAccessKeyId=LTAIjPAVS3fMSx6d&Signature=EHixlBUZslOrWGEYmcjseMdST1U%3D";
        //System.out.println(str.length());
        //testSubString();

        /*Map<String, String> params = new HashMap<>();
        params.put("name", "chu");
        params.put("key", "Hi");

        String res = getSortParams(params);
        System.out.println(res);*/

        String str = "123456789";
        String a = str.substring(0 ,6);
        System.out.println(a);

        String word = "http://rong360-raw-jxl.oss-cn-hangzhou.aliyuncs" +
                ".com/filesfiles/2018-12-05/2018-12-05-15-04-47213916252756r360_mobile_detail.zip?Expires=1575099547&OSSAccessKeyId=LTAIjPAVS3fMSx6d&Signature=EHixlBUZslOrWGEYmcjseMdST1U%3D";

        System.out.println("hi");
    }
}
