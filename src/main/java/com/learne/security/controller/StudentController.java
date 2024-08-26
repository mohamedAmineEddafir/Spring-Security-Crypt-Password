package com.learne.security.controller;

import com.learne.security.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    public static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Youssef"),
            new Student(2,"Fatima"),
            new Student(3,"Mohamed Amine")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Student "+studentId+" not found")
                );
    }
}
