package com.sparksnetworks.task.exception;

import com.sparksnetworks.task.controller.RestMatchController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Maroju, Jithender on 29/11/18
 */
@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage otherExceptions(Exception e){
        String message = e.getMessage();
        if(message == null){
            message = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() + " Please check the logs";
        }
        ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),message);
        logError(e);
        return error;
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage badRequestHandler(Exception e){
        logError(e);
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage resourceNotFoundHandler(Exception e){
        logError(e);
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    private void logError(Exception e){
        logger.error("Api call failed : " + e);
    }
}
