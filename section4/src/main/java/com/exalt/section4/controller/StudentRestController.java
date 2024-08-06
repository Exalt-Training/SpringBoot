package com.exalt.section4.controller;

import com.exalt.section4.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> allStudent;
    @PostConstruct
    public void loadData(){
        allStudent = new ArrayList<>();
        allStudent.add(new Student("Riham", "Katout"));
        allStudent.add(new Student("Siwar", "Katout"));
        allStudent.add(new Student("Ahmad", "Muneer"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return allStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return allStudent.get(studentId);
    }
}
