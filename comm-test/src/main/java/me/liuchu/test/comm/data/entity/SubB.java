package me.liuchu.test.comm.data.entity;

public class SubB extends Base{

    private String level;

    public SubB(String baseName, String level) {
        super(baseName);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
