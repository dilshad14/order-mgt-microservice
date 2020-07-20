package com.ecommerce.order.management.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.order.management.util.Constants;

import feign.FeignException;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(value = NoDataFoundException.class)
	public HttpEntity<Object> handleGenericNotFoundException(NoDataFoundException e) {
		
		return handle(Constants.NO_DATA_FOUND,e.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = ValidationException.class)
	public HttpEntity<Object> handleGenericValidationException(ValidationException e) {
		
		return handle(Constants.VALIDATION_ERROR,e.getMessage(), HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(value = Exception.class)
	public HttpEntity<Object> handleGenericException(Exception e) {
		
		return handle(Constants.GENERIC_ERROR,Constants.GENERIC_ERROR_MSG, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
    @ExceptionHandler(FeignException.class)
    public HttpEntity<Object> handleFeignStatusException(FeignException e, HttpServletResponse response) {
    	
    	return handle(Constants.REMOTE_SERVICE_ERROR,e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private HttpEntity<Object> handle(String errorCode, String errorMsg, HttpStatus httpStatus){
    	
    	ErrorResponse error = new ErrorResponse(errorCode, errorMsg);

		error.setTimestamp(LocalDateTime.now());

		error.setStatus((httpStatus.value()));
		// log the error coming from different service

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    	
    }

}
