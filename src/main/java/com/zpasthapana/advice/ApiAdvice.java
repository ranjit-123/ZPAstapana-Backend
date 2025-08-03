package com.zpasthapana.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;

import com.zpasthapana.pojo.ErrorMessage;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ApiAdvice {

	@ExceptionHandler(value = { UsernameNotFoundException.class })
	protected ResponseEntity<ErrorMessage> handleConflict(UsernameNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(new ErrorMessage("INVALID CREDENTIALS", HttpStatus.UNAUTHORIZED.value()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = { InternalServerError.class })
	protected ResponseEntity<ErrorMessage> handleConflict(InternalServerError ex, WebRequest request) {
		log.error("Internal server erro", ex);		
		return new ResponseEntity<>(new ErrorMessage("Server error", HttpStatus.INTERNAL_SERVER_ERROR.value()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
