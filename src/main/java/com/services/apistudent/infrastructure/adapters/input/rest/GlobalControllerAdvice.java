package com.services.apistudent.infrastructure.adapters.input.rest;

import com.services.apistudent.domain.exception.StudentNotFountdException;
import com.services.apistudent.domain.model.ErrorResponse;
import org.springframework.cglib.core.Local;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.services.apistudent.utils.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFountdException.class)
    public ErrorResponse handleStudentNotFountdException() {
        return ErrorResponse.builder()
                .code(STUDENT_NOT_FOUND.getCode())
                .message(STUDENT_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        return ErrorResponse.builder()
                .code(INVALID_STUDENT.getCode())
                .message(INVALID_STUDENT.getMessage())
                .details(bindingResult.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex) {
        return ErrorResponse.builder()
                .code(GENERAL_ERROR.getCode())
                .message(GENERAL_ERROR.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

}
