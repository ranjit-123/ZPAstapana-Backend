package com.zpasthapana.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.zpasthapana.pojo.ErrorMessage;

@ControllerAdvice
public class ApiAdvice {

	@ExceptionHandler(value = { UsernameNotFoundException.class })
	protected ResponseEntity<ErrorMessage> handleConflict(UsernameNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(new ErrorMessage("INVALID CREDENTIALS", HttpStatus.UNAUTHORIZED.value()),
				HttpStatus.UNAUTHORIZED);
	}
}
