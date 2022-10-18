package com.fullstack.fullstack.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.fullstack.exception.UserNotFoundException;
import com.fullstack.fullstack.model.Employee;
import com.fullstack.fullstack.repo.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepo employeeRepo;
    
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){

        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
        
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
        //employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).
        orElseThrow(
                () -> new UserNotFoundException("User by id:: " + id + " does not exist")
        );
    }
}
