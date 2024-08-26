package com.learne.security.Entity;

public class Student {
    private final Integer id;
    private final String name;

    //constructor with parameter
    public Student(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    //Getter's
    // !! int this code we can't use Setter's because my variable's is declared as final !!
    public Integer getStudentId() {
        return id;
    }
    public String getStudentName() {
        return name;
    }
}
