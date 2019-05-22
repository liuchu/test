package me.liuchu.test.comm.mvel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chuliu.demo.test.mvel.entry.Book;
import com.chuliu.demo.test.mvel.entry.Student;
import org.mvel2.MVEL;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestMvel {

    public static void test(){
        String expr = "if ( age >= 45 || age < 21) {\n" +
                "  result = \"年龄不在范围内\";\n" +
                "}\n" +
                "if ( score < 90) {\n" +
                "  result = \"分数不够\";\n" +
                "}";

        Student stu = new Student(1,25,2);
        JSONObject jsonObjectStu = (JSONObject)JSON.toJSON(stu);

        System.out.println("score: " + stu.getScore());
        jsonObjectStu.put("result","pass");

        //Book book = new Book(2,"时间简史", 200.0);
        //JSONObject jsonObjectBook = (JSONObject)JSON.toJSON(book);

        //jsonObjectStu.putAll(jsonObjectBook);

        //System.out.println(jsonObjectStu);

        MVEL.eval(expr, jsonObjectStu);

        System.out.println(jsonObjectStu.getString("result"));

        /*System.out.println("Before execute MVEL expression:");

        System.out.println("The result:"+jsonObjectStu.get("result"));

        MVEL.eval(expr, jsonObjectStu);

        System.out.println("After execute MVEL expression:");

        System.out.println("The result:"+jsonObjectStu.remove("result"));*/
    }

    public static void main(String[] args) {
        test();
    }
}
