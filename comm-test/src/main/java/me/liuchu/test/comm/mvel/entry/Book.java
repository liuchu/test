package me.liuchu.test.comm.mvel.entry;

public class Book {

    private int id;
    private String name;
    private Double price;

    public Book(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Book book = new Book(1,"bg-1", 10.0);

        //如果book的name是"bg-1", set成空
        if ("bg-1".equals(book.getName())){
            book.setName("");
        }
    }
}
