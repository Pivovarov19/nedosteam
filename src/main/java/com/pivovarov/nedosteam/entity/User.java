package com.pivovarov.nedosteam.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nickname;
    private int age;
    private String email;
    private String role;
    private int idGame;
    private String nameGame;
    @Column(name = "login", unique = true)
    private String login;
    private String password;

    public User() {
        this.role = "USER";
    }

    public User(String nickname, int age, String email) {
        this.nickname = nickname;
        this.age = age;
        this.email = email;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = "USER";
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getNickname() {return nickname;}

    public void setNickname(String nickname) {this.nickname = nickname;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}
}