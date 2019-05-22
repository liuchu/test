package me.liuchu.test.comm.data.entity;

public class Base {

    private String baseName;

    public Base(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public void printDetail(){
        System.out.println("My name is "+ baseName);
    }
}
