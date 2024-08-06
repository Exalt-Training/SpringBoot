package com.exalt.section4.controller;

import com.exalt.section4.entity.Student;
import com.exalt.section4.error_response.StudentErrorResponse;
import com.exalt.section4.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if(studentId>=allStudent.size() || studentId<0)
            throw new StudentNotFoundException("Student id not found: "+studentId);
        return allStudent.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){

        //create a StudentErrorResponse & return it
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // to catch any type exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e){

        //create a StudentErrorResponse & return it
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
