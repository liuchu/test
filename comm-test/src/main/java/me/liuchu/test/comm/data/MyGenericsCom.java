package me.liuchu.test.comm.data;

import com.chuliu.demo.test.data.entity.Base;

public class MyGenericsCom<T extends Base> {

    private T refer;

    public MyGenericsCom(T refer) {
        this.refer = refer;
    }

    public void printCom(){
        refer.printDetail();
    }
}
