package com.example.collections_sets.service;

import com.example.collections_sets.exception.EmployeeAlreadyAddedException;
import com.example.collections_sets.exception.EmployeeNotFoundException;
import com.example.collections_sets.exception.EmployeeStorageIsFullException;
import src.main.java.com.example.collections_sets.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int SIZE = 10;
    private final List<Employee> employees = new ArrayList<>();
    public void addEmployee(String firstName, String lastName){
        if(employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var employee = new Employee(firstName,lastName);
        if(employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
    }

    public Employee findEmployee(String firstName, String lastName) {
        var employee = new Employee(firstName,lastName);
        for (Employee emp : employees){
            if (emp.equals(employees)){
                return emp;
            }
        }
        throw new EmployeeNotFoundException();
    }
    public boolean removeEmployee(String firstName, String lastName){
        var employee = new Employee(firstName,lastName);
        for (Employee e : employees) {
            if (e.equals(employee)){
                employees.remove(e);
                return true;
            }
        }
        return false;

    }
}

