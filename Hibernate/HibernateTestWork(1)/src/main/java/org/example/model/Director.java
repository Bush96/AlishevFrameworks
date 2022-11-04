package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Director")
public class Director {

    @Id
    @Column(name ="director_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int director_id;

    @Column (name = "name")
    private String name;

    @Column (name = "age")
    private int age;

    @OneToMany(mappedBy = "boss")
    private List<Movie> movieList;

    public Director(){

    }

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getDirector_id() {
        return director_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Director{" +
                "director_id=" + director_id +
                ", name='" + name + '\'' +
                '}';
    }
}
