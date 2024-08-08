package com.exalt.section4_project.dao;

import com.exalt.section4_project.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findALL();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
