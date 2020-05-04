package com.pivovarov.nedosteam.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String devEmail;
    private double price;

    public Game() {
    }

    public Game(String name, String description, String devEmail, double price) {
        this.name = name;
        this.description = description;
        this.devEmail = devEmail;
        this.price = price;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {return name;}

    public String getDescription() {return description;}

    public String getDevEmail() {return devEmail;}

    public double getPrice() {return price;}

    public void setName(String name) {this.name = name;}

    public void setDescription(String description) {this.description = description;}

    public void setDevEmail(String devEmail) {this.devEmail = devEmail;}

    public void setPrice(double price) {this.price = price;}
}
