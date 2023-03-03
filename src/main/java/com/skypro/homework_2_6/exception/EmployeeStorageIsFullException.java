package com.skypro.homework_2_6.exception;

public class EmployeeStorageIsFullException extends RuntimeException{

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
