package com.kinik.mgmt.payroll.exception;

import com.kinik.mgmt.payroll.dto.ApiRespDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provide, the methods that applied to all REST API controllers
 * class in our application.
 *
 * @author oguzhankinik
 */
@ControllerAdvice
public class RestApiExceptionHandler {

    /**
     * This handler method triggers with domain @Valid annotation in request body.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        BindingResult result = ex.getBindingResult();
        result.getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleException(Exception ex, HttpHeaders headers, HttpStatus status,
                                                     WebRequest request) {
        return buildResponseEntity(new ApiRespDto(false, HttpStatus.ACCEPTED.ordinal(), ex.getMessage(), "", null));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiRespDto apiRespDto) {
        return ResponseEntity.ok(apiRespDto);
    }

}