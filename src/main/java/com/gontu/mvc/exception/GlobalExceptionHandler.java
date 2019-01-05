package com.gontu.mvc.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView handleNullPointrException(Exception e) {
		ModelAndView mv=new ModelAndView("GenericException");
		mv.addObject("exceptionType", "NullPointerException");
		System.out.println("NullPointerException occurred in Global:"+e);
		return mv;
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = IOException.class)
	public ModelAndView handleIOException(Exception e) {
		ModelAndView mv=new ModelAndView("GenericException");
		mv.addObject("exceptionType", "IOException");
		System.out.println("IOException occurred:"+e);
		return mv;
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mv=new ModelAndView("GenericException");
		mv.addObject("exceptionType", e.getMessage());
		System.out.println("Exception occurred:"+e);
		return mv;
	}
}
