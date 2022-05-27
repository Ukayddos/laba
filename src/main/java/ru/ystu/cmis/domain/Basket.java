package ru.ystu.cmis.domain;

public class Basket {
    private Integer id;
    private Fruit fruit;
    private int count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Fruit getFruits() {
        return fruit;
    }

    public void setFruits(Fruit fruit) {
        this.fruit = fruit;
    }
}
