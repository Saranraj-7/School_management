package com.Fyndus.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Fyndus.DTO.ErrorResponse;
import com.Fyndus.exception.ErrorHandler;
import com.Fyndus.exception.NoRecordsFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ErrorHandler.class)
	public ResponseEntity<ErrorResponse> handleSchoolAlreadyExistsException(ErrorHandler e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoRecordsFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoRecordsFoundException(NoRecordsFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
}
