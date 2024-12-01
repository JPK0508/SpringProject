package com.facebook.controller;

import com.facebook.entity.Employee;
import com.facebook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.saveEmployee(employee);
        System.out.println(emp.getId());
        return ResponseEntity.status(200).body(emp);
    }

    @GetMapping(value = "/getEmployees")
    public List<Employee> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
//http://localhost:8080/employee/deleteEmployee/2
    @DeleteMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployeeUsingPathVariable(@PathVariable  Long id){
        Long aLong = employeeService.deleteEmployee(id);
        return "Employee deleted successfully with id: "+id;
    }
//http://localhost:8080/employee/deleteEmployee?id=1
    @DeleteMapping(value = "/deleteEmployee")
    public String deleteEmployeeUsingRequestParam(@RequestParam  Long id){
        Long aLong = employeeService.deleteEmployee(id);
        System.out.println(aLong);
        return "Employee deleted successfully with id: "+id;
    }

    @PutMapping("/updateEmployee" )
    public Employee updateEmployee(@RequestBody Employee employee, @RequestParam Long id){
        Employee employee1 = employeeService.updateEmployee(employee,id);
        return employee1;
    }
}
