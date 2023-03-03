package com.skypro.homework_2_6.service;

import com.skypro.homework_2_6.Employee;
import com.skypro.homework_2_6.exception.EmployeeAlreadyAddedException;
import com.skypro.homework_2_6.exception.EmployeeNotFoundException;
import com.skypro.homework_2_6.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    private final ArrayList<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() > 9) {
            throw new EmployeeStorageIsFullException("массив сотрудников переполнен");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("такой сотрудник уже есть");
        }
        employees.add(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = null;
        for (Employee value : employees) {
            if (firstName.equals(value.getFirstName()) && lastName.equals(value.getLastName())) {
                employee = value;
            }
        }
        if (employee == null) {
            throw new EmployeeNotFoundException("сотрудник не найден");
        }
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(findEmployee(firstName, lastName));
            return employee;
    }

    public ArrayList<Employee> printEmployee() {
        return employees;
    }

}
