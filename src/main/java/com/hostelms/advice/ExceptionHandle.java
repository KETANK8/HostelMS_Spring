package com.hostelms.advice;

import java.util.HashMap;
import java.util.Map;

import com.hostelms.exception.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> InvalidArgumentHandler(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(GlobalException.class)
	public Map<String, String> GlobalExceptionHandler(GlobalException gEx) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Exception : ", gEx.getMessage());
		return errorMap;
	}
}