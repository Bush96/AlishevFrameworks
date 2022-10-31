package org.example.model;

import jakarta.persistence.*;

@Entity          //Аннотация сущности, только с ними работает хайбернет
@Table(name = "Person")            //название таблицы в бд
public class Person {
    @Id
    //обязательно помечаем определенный столбец этой аннотацией, чтобы знать что является первичныи ключом
    @Column(name = "id")            //название колонки в бд
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.IDENTITY) - передаем на бд управление этой колонкой, раз она заполняется автоматически
    private int id;

    @Column(name = "name")           //
    private String name;

    @Column(name = "age")            //
    private int age;

    public Person() {
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
        return this.name + " , " + this.age;
    }
}
