package io.lpamintuan.backend.backend.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value =  {NotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFoundException(Exception ex) {
        return new ApiError(ex, HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleInvalidFormatException(InvalidFormatException ex) {
        return new ApiError(ex, HttpStatus.BAD_REQUEST.value());
    }
    
}