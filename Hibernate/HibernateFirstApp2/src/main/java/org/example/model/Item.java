package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "item_name")
    private String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }


    public Item(String itemName, Person owner) {
        this.itemName = itemName;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public Person getOwner() {
        return owner;
    }

    public String getItemName() {
        return itemName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", owner=" + owner +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
