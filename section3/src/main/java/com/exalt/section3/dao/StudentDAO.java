package com.exalt.section3.dao;

import com.exalt.section3.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
}
