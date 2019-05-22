package me.liuchu.test.comm.data;

import com.chuliu.demo.test.data.entity.Base;
import com.chuliu.demo.test.data.entity.SubA;
import com.chuliu.demo.test.data.entity.SubB;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {

    public static void test1(){
        MyGenericsObj<String> strObj = new MyGenericsObj<>("Hello!");
        String strRes =  strObj.getRefer();
        System.out.println(strRes);
        strObj.printRefer("Must a str");

        Double self1 = strObj.getItsSelf(1.0);
        System.out.println(self1);

        MyGenericsObj<Integer> intObj = new MyGenericsObj<>(2);
        Integer intRes =  intObj.getRefer();
        System.out.println(intRes);
        intObj.printRefer(100);

        Double self2 = intObj.getItsSelf(2.0);
        System.out.println(self2);
    }

    public static void test2(){
        List<Base> baseList = new ArrayList<>();
        baseList.add(new Base("base-Lee"));
        baseList.add(new SubA("subA-Mike", 50));
        baseList.add(new SubB("subA-Jake", "2.0"));

        for (Base base : baseList) {
            base.printDetail();
        }
    }

    public static void test3(){
        List<SubA> subAList = new ArrayList<>();
        //List<Base> temp = subAList; 这一行会编译错误
        //subAList.add(new Base("I', base")); 这一行会编译错误

        //使用无限定通配符，ultimateList只能调用类型无关的方法
        List<?> ultimateList = new ArrayList<>();
        //ultimateList.add(1); 这一行会编译错误
        System.out.println(ultimateList.size());
        System.out.println(ultimateList.hashCode());

        //使用上边界通配符，ultimateList依然调用类型无关的方法
        List<? extends Base> upperBondList = new ArrayList<>();
        //upperBondList.add(new Base("A"));

        List<Base> baseList = new ArrayList<>();
        List<SubA> listA = new ArrayList<>();
        List<SubB> listB = new ArrayList<>();
        System.out.println("super size is "+getSuperSize(baseList));
        System.out.println("super size is "+getSize(baseList));
        System.out.println("super size is "+getSize(listA));
        System.out.println("super size is "+getSize(listB));

    }

    private static void test5(){
        //MyGenericsCom<SubA> myGenericsCom = new MyGenericsCom<>(new SubA("L", 90));
        MyGenericsCom<Base> myGenericsCom = new MyGenericsCom<>(new SubA("L", 90));
    }

    private static int getSize(List<? extends Base> list){
        return list.size();
    }

    private static void addAnElement(List<? extends Base> list){
        //list.add(new Base("a")); 这一行会编译错误
    }

    private static void addAnElementSuper(List<? super Base> list){
        list.add(new Base("a"));
    }

    private static int getSuperSize(List<? super Base> list){
        return list.size();
    }

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();

    }
}
