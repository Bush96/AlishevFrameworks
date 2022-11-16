package springcourse.models;


import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "item_name")
    private String item_name;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Item(){

    }

    public Item(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getItem_name() {
        return item_name;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Item{" +
                ", item_name='" + item_name + '\'' +
                '}';
    }
}
