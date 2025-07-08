package com.jefferson.vidaplus.exceptions;

import com.jefferson.vidaplus.exceptions.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ExceptionResponse> buildResponseEntity (Exception exception, HttpServletRequest request, HttpStatus status){
        ExceptionResponse response = new ExceptionResponse(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getRequestURI(),
                status.value()
        );

        return ResponseEntity.status(status).body(response);

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleGenericException(Exception exception, HttpServletRequest request){
        return buildResponseEntity(exception, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(EntityNotFoundException exception, HttpServletRequest request){
        return buildResponseEntity(exception, request, HttpStatus.NOT_FOUND);
    }


}
