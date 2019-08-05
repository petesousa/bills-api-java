package com.deliver.bills.exception.advice;

import com.deliver.bills.dto.ExceptionInfo;
import com.deliver.bills.controller.BillController;
import com.deliver.bills.exception.BadRequestException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice(basePackageClasses = BillController.class)
public class BillControllerAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(value = BadRequestException.class)
    public ExceptionInfo BadRequestExceptionHandler(BadRequestException ex) {
        return ExceptionInfo.builder()
                .status(BAD_REQUEST)
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ExceptionInfo ExceptionHandler(Exception ex) {
        return ExceptionInfo.builder()
                .status(INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .build();
    }

}