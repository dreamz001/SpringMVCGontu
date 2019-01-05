package com.gontu.mvc.exception;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView handleNullPointrException(Exception e) {
		ModelAndView mv=new ModelAndView("GenericException");
		mv.addObject("exceptionType", "NullPointerException");
		System.out.println("NullPointerException occurred in Global:"+e);
		return mv;
	}
	
	@ExceptionHandler(value = IOException.class)
	public ModelAndView handleIOException(Exception e) {
		ModelAndView mv=new ModelAndView("GenericException");
		mv.addObject("exceptionType", "IOException");
		System.out.println("IOException occurred:"+e);
		return mv;
	}
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mv=new ModelAndView("GenericException");
		mv.addObject("exceptionType", e.getMessage());
		System.out.println("Exception occurred:"+e);
		return mv;
	}
}
