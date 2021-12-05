package com.example.TheProject.Model;

import javax.persistence.*;

@Entity
@Table(name="StudentsDetail")
public class StudentOne {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="Name")
    private String name;
    @Column(name="Age")
    private int age;

    public StudentOne(){

    }

    public StudentOne(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
