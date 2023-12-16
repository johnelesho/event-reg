package edu.blazeskill.event.controllers;

import edu.blazeskill.event.dtos.ApiResponse;
import edu.blazeskill.event.exceptions.ApiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler { //extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiNotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFound(ApiNotFoundException exception){
        ApiResponse response = ApiResponse.builder()
                .success(false)
                .description(exception.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleOtherException(Exception exception){
        ApiResponse response = ApiResponse.builder()
                .success(false)
                .description(exception.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}
