package me.liuchu.test.comm.common;

import com.chuliu.demo.test.common.annotation.AnnotionDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotation {

    @AnnotionDemo(name = "Chu", value = "Man")
    public void test(Integer number){
        System.out.println("A method with @AnnotionDemo annoted, the arg is "+number);
    }

    public void showAnnotationDetail(){
        test(12);
        try {
            Method method = this.getClass().getMethod("test",Integer.class);
            System.out.println("The method name:"+method.getName());

            String name = method.getAnnotation(AnnotionDemo.class).name();
            String value = method.getAnnotation(AnnotionDemo.class).value();
            System.out.println("name:"+name+" value:"+value);

            String method1 = method.getName();
            String name1 = this.getClass().getTypeName();

            System.out.println("The name: "+name1 + ":" + method1);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //new TestAnnotation().showAnnotationDetail();
        /*String lastExtendId = "123456ex5";
        String val = lastExtendId.substring(lastExtendId.indexOf("ex")+2);

        System.out.println(val);*/

        Integer a = Integer.parseInt("x112");
        System.out.println(a);

    }
}
