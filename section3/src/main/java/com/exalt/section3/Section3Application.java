package com.exalt.section3;

import com.exalt.section3.dao.StudentDAO;
import com.exalt.section3.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Section3Application {

    public static void main(String[] args) {
        SpringApplication.run(Section3Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student ...");
        Student tmpStudent = new Student("Riham", "Katout", "test@gmail.com");
        System.out.println("Saving the student ...");
        studentDAO.save(tmpStudent);
        System.out.println("Saved student. Generated id: " + tmpStudent.getId());
    }
}
