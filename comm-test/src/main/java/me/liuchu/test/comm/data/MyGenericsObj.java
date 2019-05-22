package me.liuchu.test.comm.data;

public class MyGenericsObj<T> {

    private T refer;

    public MyGenericsObj(T refer) {
        this.refer = refer;
    }

    public T getRefer(){
        return refer;
    }

    public <E> E getItsSelf(E e){
        return e;
    }

    public <M> void voidItsSelf(M m){
        System.out.println(m.hashCode());
    }

    public void printRefer(T t){
        System.out.println(t);
    }

}
