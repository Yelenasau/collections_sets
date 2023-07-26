package com.example.collections_sets.controller;

import com.example.collections_sets.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.example.collections_sets.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
            this.service = service;
    }
    @GetMapping ("/add")
    public void add(@RequestParam String firstName, @RequestParam String lastName){
        service.addEmployee(firstName,lastName);

    } @GetMapping ("/get")
    public Employee get(@RequestParam String firstName, @RequestParam String lastName){
        return service.findEmployee(firstName,lastName);

    } @GetMapping ("/remove")
    public boolean remove(@RequestParam String firstName, @RequestParam String lastName){
        return service.removeEmployee(firstName,lastName);
    }

}
