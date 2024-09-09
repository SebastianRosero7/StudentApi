package com.services.apistudent.utils;


import lombok.Getter;

@Getter
public enum ErrorCatalog {
    STUDENT_NOT_FOUND("ERROR_STUDENT_001", "Student not found"),
    INVALID_STUDENT("ERROR_STUDENT_002", "Invalid student"),
    GENERAL_ERROR("ERROR_GEN_001", "An unexpected error occurred");

    private final String code;
    private final String message;


    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
