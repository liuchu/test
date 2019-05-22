package me.liuchu.test.comm.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileTest {

    public static void readFile() throws IOException {

        String path = "C:\\Users\\dell\\Desktop\\fields.txt";

        File file = new File(path);//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String str = "";
        while ((str =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            //sb.append(str + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            System.out.println("zzcFeature.set"+upperFirstLetter(str)+"(-1);");
        }
        bReader.close();
    }

    private static String upperFirstLetter(String str){

        str = str.trim();

        if (str.length() <= 0) {
            return str;
        }
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    private static Map<Integer, Integer> getUploadMap() throws IOException {

        Map<Integer, Integer> map = new HashMap<>();

        String issuePath = "C:\\Users\\dell\\Desktop\\issue.txt";
        String extendPath = "C:\\Users\\dell\\Desktop\\extend.txt";
        String trackPath = "C:\\Users\\dell\\Desktop\\track.txt";

        String[] files = new String[]{issuePath, extendPath, trackPath};

        for (int i = 0; i < files.length; i++) {
            BufferedReader bReader1 = new BufferedReader(new FileReader(new File(files[i])));
            String str1;
            while ((str1 =bReader1.readLine()) != null) {

                if (str1.contains("5828417")) {
                    System.out.println(str1);
                }

                String id = str1.trim().split("风控id:")[1].split("，返回的id")[0];

                //System.out.println(id);
                map.put(Integer.valueOf(id), i+1);
            }
            bReader1.close();
        }

        return map;

    }

    private static void testSplit(){
        String str = "2018-12-20 03:57:44.445 INFO  [task-pool-3]com.xjx.risk.credit.task.CreditUploadTask.uploadZzcTrackSingle:513 -状态更新数据上报成功，风控id:5828417，返回的id:5828417, httpResponse:{\"id\":\"5828417\",\"status\":\"success\"}\n";

        String id = str.trim().split("风控id:")[1].split("，返回的id")[0];

        System.out.println(id);

    }

    private static void testSubString(){

        String input = "ABC{123}abc{456}";

        String res = input.substring(input.indexOf("{"));

        System.out.println(res);

    }

    public static void main(String[] args) throws IOException {
        //getUploadMap();
        //testSplit();
        testSubString();
    }

}
