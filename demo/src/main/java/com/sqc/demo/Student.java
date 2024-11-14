package com.sqc.demo;

public class Student {
    private  int id;
    private  String name;
    private  int scroe;

    public Student(){}

    public Student(int id, String name, int scroe) {
        this.id = id;
        this.name = name;
        this.scroe = scroe;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScroe() {
        return scroe;
    }

    public void setScroe(int scroe) {
        this.scroe = scroe;
    }
}
