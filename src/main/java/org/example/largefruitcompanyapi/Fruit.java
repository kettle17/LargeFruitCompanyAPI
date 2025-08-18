package org.example.largefruitcompanyapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Fruit {

    private @Id
    @GeneratedValue long id;
    private String name;
    private double price;

    Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Fruit() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}