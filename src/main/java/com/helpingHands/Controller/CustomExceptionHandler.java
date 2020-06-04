package com.helpingHands.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.helpingHands.Exception.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	private ModelAndView mv = new ModelAndView("error.jsp");
	private HttpStatus status;
	private String message;
	

	@ExceptionHandler(Exception.class)
	public final ModelAndView handleAllExceptions(Exception ex, WebRequest request) {		
		status = HttpStatus.INTERNAL_SERVER_ERROR;
		message = "Somthing Went Wrong"; 	
		ErrorResponse errorResponse = new ErrorResponse(status, message);
		mv.addObject("error", errorResponse);
		return mv;
	}

}