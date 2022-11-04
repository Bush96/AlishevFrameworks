package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;

    @Column(name = "name")
    private String name;

    @Column(name = " year_of_production")
    private int year_of_production;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director boss;

    public Movie() {

    }

    public Movie(String name, int year_of_production) {

        this.name = name;
        this.year_of_production = year_of_production;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getName() {
        return name;
    }

    public int getYear_of_production() {
        return year_of_production;
    }

    public Director getBoss() {
        return boss;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear_of_production(int year_of_production) {
        this.year_of_production = year_of_production;
    }

    public void setBoss(Director boss) {
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", name='" + name + '\'' +
                ", year_of_production=" + year_of_production +
                ", boss=" + boss +
                '}';
    }
}
