package com.pivovarov.nedosteam;

public class User {
    private long id;
    private String nickname;
    private int age;
    private String email;

    public User() {
    }

    public User(String nickname, int age, String email) {
        this.nickname = nickname;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}