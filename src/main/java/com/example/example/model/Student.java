package com.example.model;

public class Student {
    private int id;
    private String name;
    private String sport;
    private int age;

    public Student() {
    }

    public Student(int id, String name, String sport, int age) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.age = age;
    }

    // Constructor for inserting (without ID)
    public Student(String name, String sport, int age) {
        this.name = name;
        this.sport = sport;
        this.age = age;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
