package me.liuchu.test.comm.data.entity;

public class Student {

    private Integer id;
    private Integer age;
    private Integer gender;

    private Integer score;

    public Student(Integer id, Integer age, Integer gender) {
        this.id = id;
        this.age = age;
        this.gender = gender;
    }

    public Student(Integer id, Integer age, Integer gender, Integer score) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", gender=" + gender +
                ", score=" + score +
                '}';
    }
}
