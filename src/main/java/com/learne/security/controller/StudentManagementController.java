package com.learne.security.controller;

import com.learne.security.Entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/student")
public class StudentManagementController {

    public static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Youssef"),
            new Student(2,"Fatima"),
            new Student(3,"Mohamed Amine")
    );

    @GetMapping
    public List<Student> getStudents() {
        System.out.println("List of students Showed");
        return STUDENTS;
    }
    @PostMapping
    public void setStudents(@RequestBody Student student) {
        System.out.println("Add Student successfully");
        System.out.println(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("Delete Student successfully");
        System.out.println(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void editStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("update Student successfully");
        System.out.println(String.format("%s %s", student, student));
    }
}
