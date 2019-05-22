package me.liuchu.test.comm.mvel;

import com.chuliu.demo.test.mvel.entry.Student;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {

    public static void test(){

        List<Student> list = new ArrayList<>();

        Student data1 = new Student(1,20,1,50);
        Student data2 = new Student(2,27,1);
        Student data3 = new Student(3,28,1);
        Student data4 = new Student(4,22,0);
        Student data5 = new Student(5,24,1);

        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);

        list.stream()
                .filter(s -> s.getAge()==20)
                .forEach(s -> s.setScore(99));

        System.out.println(list.get(0).getScore());

        /*int res = list.stream().
                mapToInt(Student::getScore).
                max().
                orElse(0);

        System.out.println("result:"+res);*/

        /*System.out.println("The boy whose age > 25 and score >= 90 ");
        list.stream()
                .filter(Objects::nonNull)
                .filter(stu -> stu.getAge()>25)
                .filter(stu -> stu.getGender()==1)
                .filter(stu -> stu.getScore()>=90)
                .map(Student::getId)
                .collect(Collectors.toList()).forEach(id -> System.out.println("ID:"+id));*/

    }

    public static void testMax(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, 20, 1, 80));
        list.add(new Student(2, 21, 1, 90));
        list.add(new Student(3, 22, 0, 90));

        String a = list.stream().max(Comparator.comparingInt(Student::getScore)).get().toString();

        System.out.println(a);
    }

    public static void main(String[] args) {
        test();

        //testMax();
        /*String userpass = "liuchu:ABCD";
        String rsult = new String(Base64.getEncoder().encode(userpass.getBytes()));

        System.out.println(rsult);
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        String[] array = new String[list.size()];
        array = list.toArray(array);

        new ArrayList<>(1);
        new HashMap<>(1);*/



    }

}
