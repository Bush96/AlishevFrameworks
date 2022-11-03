package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<Item> items;            //так устанавливаем связь с другой таблицей

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Person() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//здесь применяем рефакторинг для упрощения кода
    public void addItem(Item item) {
        if (this.items == null)
            this.items = new ArrayList<>();

        this.items.add(item);
        item.setOwner(this);


    }
}
