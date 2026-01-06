package com.gfg.employeaap.controller;

import com.gfg.employeaap.entity.Employee;
import com.gfg.employeaap.response.EmployeeResponse;
import com.gfg.employeaap.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) 
    {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
    
    @GetMapping("/employees")
    private ResponseEntity<List<Employee>> getAllEmployees() 
    {
    	List<Employee> emp = employeeService.getall();
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }

}