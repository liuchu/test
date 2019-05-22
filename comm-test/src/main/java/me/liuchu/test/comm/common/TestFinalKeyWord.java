package me.liuchu.test.comm.common;

public class TestFinalKeyWord {

    private final Integer id;

    public TestFinalKeyWord(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void doSth(){

    }

    public static void main(String[] args) {

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String m = "hello";

        String c = b + 2;
        String e = d + 2;

        System.out.println((a == c));
        System.out.println((a == e));

        System.out.println(d == "hello");
        System.out.println(d + "2" == "hello"+"2");
    }

}
