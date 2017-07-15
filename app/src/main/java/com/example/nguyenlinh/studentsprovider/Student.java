package com.example.nguyenlinh.studentsprovider;

/**
 * Created by nguyenlinh on 15/07/2017.
 */

public class Student {
    private String ID;
    private String name;
    private String grade;

    public Student() {
    }

    public Student(String ID, String name, String grade) {
        this.ID = ID;
        this.name = name;
        this.grade = grade;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
