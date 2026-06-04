package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentErrorHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleNotFoundException(StudentNotFoundException exc){
        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        //return the error as the response body and set the error status to 404
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Catch all other exception apart from non from StudentNotFoundException
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllExceptions(Exception exc){
        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setMessage(exc.getMessage());
        errorResponse.setMessage("Invalid or unknown request");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
