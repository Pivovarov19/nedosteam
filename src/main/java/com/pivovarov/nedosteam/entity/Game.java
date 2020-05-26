package com.pivovarov.nedosteam.entity;

import javax.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String devNickname;
    private long devId;
    private double price;

    public Game() {
    }

    public Game(String name, String description, String devNickname, double price, int devId) {
        this.name = name;
        this.description = description;
        this.devNickname = devNickname;
        this.price = price;
        this.devId = devId;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {return name;}

    public String getDescription() {return description;}

    public String getDevNickname() {return devNickname;}

    public double getPrice() {return price;}

    public void setName(String name) {this.name = name;}

    public void setDescription(String description) {this.description = description;}

    public void setDevNickname(String devEmail) {this.devNickname = devEmail;}

    public void setPrice(double price) {this.price = price;}

    public long getDevId() {return devId;}

    public void setDevId(long devId) {this.devId = devId;}
}