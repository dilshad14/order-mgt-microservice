package com.ecommerce.product.management.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.product.management.util.Constants;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(value = NoDataFoundException.class)
	public HttpEntity<Object> handleGenericNotFoundException(NoDataFoundException e) {

		ErrorResponse error = new ErrorResponse("NOT_FOUND", e.getMessage());

		error.setTimestamp(LocalDateTime.now());

		error.setStatus((HttpStatus.NOT_FOUND.value()));

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = ValidationException.class)
	public HttpEntity<Object> handleGenericValidationException(ValidationException e) {

		ErrorResponse error = new ErrorResponse("VALIDATION_ERROR", e.getMessage());

		error.setTimestamp(LocalDateTime.now());

		error.setStatus((HttpStatus.BAD_REQUEST.value()));

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(value = Exception.class)
	public HttpEntity<Object> handleGenericException(Exception e) {

		ErrorResponse error = new ErrorResponse("GENERIC_ERROR", Constants.GENERIC_ERROR);

		error.setTimestamp(LocalDateTime.now());

		error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
