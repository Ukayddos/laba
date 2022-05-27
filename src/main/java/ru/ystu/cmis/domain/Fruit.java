package ru.ystu.cmis.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Fruit")
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Column
    private String name;
    @Column
    private Integer price;
    @Column
    private Integer count;

    public Fruit(String _name, Integer _price, Integer _count){
        name = _name;
        price = _price;
        count = _count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getPrice(){
        return price;
    }

    public void setPrice(Integer price){
        this.price = price;
    }

    public Integer getCount(){
        return count;
    }

    public void setCount(Integer count){
        this.count = count;
    }
}