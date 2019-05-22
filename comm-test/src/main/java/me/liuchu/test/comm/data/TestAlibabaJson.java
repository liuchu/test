package me.liuchu.test.comm.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chuliu.demo.test.data.entity.Contact;
import com.chuliu.demo.test.data.entity.Student;
import com.chuliu.demo.test.utils.StringUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestAlibabaJson {

    public static String testJsonStr = "{\"age\":20,\"gender\":1,\"id\":null}";


    /**
     * 获取一个JSONObject字符串的一级字节点
     */
    public void getElementsOfRoot() throws IOException {
        String filePath = "C:\\Users\\dell\\Desktop\\json示例 运营商报告3.0.txt";
        String jsonStr = readFile(filePath);

        JSONObject jsonObj = JSON.parseObject(jsonStr);
        jsonObj.keySet().forEach(System.out::println);
        System.out.println("--------------");
        jsonObj.getJSONObject("tianji_api_tianjireport_detail_response").keySet().forEach(System.out::println);
    }

    public static void testJsonArray() throws IOException {

        String file1 = "C:\\Users\\dell\\Desktop\\temp751.txt";

        String file2 = "C:\\Users\\dell\\Desktop\\temp.txt";

        JSONArray array1 = JSON.parseArray(readFile(file1));
        JSONArray array2 = JSON.parseArray(readFile(file2));

        List<String> nameList1 = new ArrayList<>();
        List<String> nameList2 = new ArrayList<>();

        for (int i=0;i<array1.size();i++) {
            nameList1.add(array1.getJSONObject(i).getString("name"));
        }

        for (int i=0;i<array2.size();i++) {
            nameList2.add(array2.getJSONObject(i).getString("name"));
        }

        for (String name : nameList1) {
            if (!nameList2.contains(name)) {
                System.out.println(name);
            }
        }

        /*System.out.println(JSON.parseArray(jsonStr1).size());

        System.out.println(JSON.parseArray(jsonStr2).size());*/

    }

    private static void testContacts() throws IOException {

        String file = "C:\\Users\\dell\\Desktop\\temp.txt";

        JSONArray array1 = JSON.parseArray(readFile(file));
        System.out.println("去重前："+array1.size());

        List<Contact> list = array1.toJavaList(Contact.class).stream().distinct().collect(Collectors.toList());

        System.out.println("去重后："+list.size());
    }

    private static String readFile(String path) throws IOException {
        File file = new File(path);//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s).append("\n");//将读取的字符串添加换行符后累加存放在缓存中
        }
        bReader.close();
        return sb.toString();
    }

    private static void testMapToJson(){

        Map<String, String> map = new HashMap<>(3);
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");

        JSONObject jsonObject = (JSONObject) JSON.toJSON(map);
        System.out.println(jsonObject.toJSONString());
    }

    public static void main(String[] args) throws IOException {

        //new TestAlibabaJson().getElementsOfRoot();

        Student student = JSON.parseObject(testJsonStr,Student.class);

        System.out.println(student);

        /*List<Integer> ids = new ArrayList<>(3);
        ids.add(111);
        ids.add(222);
        ids.add(333);

        String result = JSON.toJSONString(ids);
        String result2 = JSON.toJSONString(ids,true);

        System.out.println(result);
        System.out.println(result2);*/
        /*LocalDate regDate =  LocalDate.parse("2018-11-13");
        long days = regDate.until(LocalDate.now(), ChronoUnit.DAYS);
        System.out.println(days);*/

        //testJsonArray();

        testMapToJson();
    }
}
