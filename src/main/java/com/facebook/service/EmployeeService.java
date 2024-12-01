package com.facebook.service;

import com.facebook.entity.Employee;
import com.facebook.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }
    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }
    
    public Long deleteEmployee(Long id){
        Long empId=0L;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            employeeRepository.deleteById(id);
            Employee employee = optionalEmployee.get();
            empId= employee.getId();
        }
        else{
            throw new RuntimeException("Employee is not present: "+ id);
        }
        return empId;
    }


    public Employee updateEmployee(@RequestBody Employee employee, Long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee1 = optionalEmployee.get();
            employee1.setName(employee.getName());
            employee1.setLocation(employee.getLocation());
            employee1.setSalary(employee.getSalary());
            return  employeeRepository.save(employee1);
        }
        else {
            throw new RuntimeException("Employee is not present in db: "+id);
        }
    }
}
