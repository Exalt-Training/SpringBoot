package com.exalt.section4_project.controller;

import com.exalt.section4_project.dao.EmployeeDAO;
import com.exalt.section4_project.entity.Employee;
import com.exalt.section4_project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee){

        // just in case they passed an id, set the id to 0 to force a save instead of update
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId){
        try{
            employeeService.deleteById(employeeId);
            return "Employee was deleted successfully.";
        }catch (Exception e){
            return ("Employee Id is not found: "+employeeId);
        }
    }
}
