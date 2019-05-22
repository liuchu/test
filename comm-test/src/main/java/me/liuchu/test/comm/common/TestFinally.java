package me.liuchu.test.comm.common;

public class TestFinally {

    public static void test(){
        try{
            int a = 1;
            System.out.println(a);
            return;
        }finally {
            System.out.println("FINALLY");
        }
    }

    public static void testPhone(){

        String loanPhone = "187543919181";
        String riskPhone = "18754391918";

        if (loanPhone.length() > 11) {
            if (!riskPhone.equals(loanPhone.substring(0, 11))) {
                throw new RuntimeException("Wrong, phone not match 1");
            }
        } else {//身份证小于18位(或等于)，则截取到17位和16位后分别比较
            if (!riskPhone.substring(0, 10).equals(loanPhone)
                    && !riskPhone.substring(0, 9).equals(loanPhone)) {
                throw new RuntimeException("Wrong, phone not match 2");
            }
        }
    }

    public static void main(String[] args) {

        test();

    }
}
