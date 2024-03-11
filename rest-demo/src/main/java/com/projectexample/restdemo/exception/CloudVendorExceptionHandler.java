package com.projectexample.restdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
//Exception handling
@ControllerAdvice
public class CloudVendorExceptionHandler {
    @ExceptionHandler(value = CloudVendorNotFoundException.class)
    public ResponseEntity<Object> handleCloudVendorNotFoundException
            (CloudVendorNotFoundException cloudVendorNotFoundException)
    {
        CloudVendorException cloudVendorException=new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);

        return  new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public  ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        Map<String,String>response=new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) ->{
            String filedName=((FieldError)error).getField();
           String message= error.getDefaultMessage();

        } );
        return  new ResponseEntity<Map<String, String>>(response,HttpStatus.BAD_REQUEST);


    }
}
