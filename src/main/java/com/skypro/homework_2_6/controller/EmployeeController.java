package com.skypro.homework_2_6.controller;

import com.skypro.homework_2_6.Employee;
import com.skypro.homework_2_6.exception.EmployeeAlreadyAddedException;
import com.skypro.homework_2_6.exception.EmployeeNotFoundException;
import com.skypro.homework_2_6.exception.EmployeeStorageIsFullException;
import com.skypro.homework_2_6.exception.ErrorMessage;
import com.skypro.homework_2_6.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.ErrorManager;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ErrorMessage handleException(EmployeeAlreadyAddedException e) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public ErrorMessage handleException(EmployeeStorageIsFullException e) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ErrorMessage handleException(EmployeeNotFoundException e) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String  firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String  firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String  firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/print")
    public ArrayList<Employee> printEmployee() {
        return employeeService.printEmployee();
    }






}
