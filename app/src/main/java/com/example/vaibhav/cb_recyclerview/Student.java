package com.example.vaibhav.cb_recyclerview;

/**
 * Created by vaibhav on 15-06-2017.
 */

public class Student {
    String name,course;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
