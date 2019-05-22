package me.liuchu.test.comm.cache;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@EqualsAndHashCode("true")
public class Idempotent {

    private String name;

    //public interface to outside world
    public void doSomeImportant(){
        thingA();
        thingB();
        thingC();
        thingD();
    }

    private void thingA(){}
    private void thingB(){}
    private void thingC(){}
    private void thingD(){}

}
