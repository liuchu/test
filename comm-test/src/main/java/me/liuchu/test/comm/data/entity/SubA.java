package me.liuchu.test.comm.data.entity;

public class SubA extends Base {

    private Integer score;

    public SubA(String name, Integer score){
        super(name);
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}


