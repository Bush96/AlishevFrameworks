package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "School")
public class School  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    private Principal principal;

    @Column(name = "school_number")
    private int schoolNumber;

    public School(){

    }

    public School(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", principal=" + principal +
                ", schoolNumber=" + schoolNumber +
                '}';
    }
}
