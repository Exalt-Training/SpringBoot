package com.exalt.section4_project.controller;

import com.exalt.section4_project.dao.EmployeeDAO;
import com.exalt.section4_project.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Autowired

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeDAO.findALL();
    }
}
