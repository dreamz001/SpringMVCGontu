package com.gontu.mvc.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.annotation.WebInitParam;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gontu.mvc.editor.StudentNameEditor;
import com.gontu.mvc.model.Student;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admission-form", method = RequestMethod.GET)
	public ModelAndView displayAdmissionForm() {
		ModelAndView mv=new ModelAndView("admission-form");
		//mv.addObject("headerMessage", "Best College of Engineering, India");
		return mv;
	}
	
	@InitBinder
	public void setInitBinder(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat format= new SimpleDateFormat("yyyy****MM****dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(format, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	/*@RequestMapping(value="/submit-admission-form", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name,
			@RequestParam("studentHobby") String hobby,@RequestParam("studentMobile") String mobile,
			@RequestParam("studentDOB") String dob,@RequestParam("studentSkills") String[] skills) throws Exception {
		Student stud=new Student(name, hobby);
		//step-13
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		stud.setStudentDOB(format.parse(dob));
		stud.setStudentMobile(Long.parseLong(mobile));
		ArrayList<String> studentSkills=new ArrayList<String>();
		for(String skill:skills) {
			studentSkills.add(skill);
		}
		stud.setStudentSkills(studentSkills);
		// end step-13
		ModelAndView mv=new ModelAndView("admission-success");
		//mv.addObject("headerMessage", "Best College of Engineering, India");
		mv.addObject("studentObj", stud);
		return mv;
	}*/
	@ModelAttribute
	public void  addCommonObjects(Model model1) {
		model1.addAttribute("headerMessage", "Best College of Engineering, India");
	}
	@RequestMapping(value="/submit-admission-form", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("studentObj")Student stud, BindingResult result )throws Exception {
		if(stud.getStudentAddress().getStreet().toLowerCase().contains("exception")) {
			if(stud.getStudentAddress().getStreet().toLowerCase().contains("nullpointer")) {
				throw new NullPointerException();
			}else if(stud.getStudentAddress().getStreet().toLowerCase().contains("ioexception")) {
				throw new IOException();
			}else {
				throw new Exception(stud.getStudentAddress().getStreet());
			}
		}
		if(result.hasErrors()) {
			ModelAndView mv_errors=new ModelAndView("admission-form");
			return mv_errors;
		}
		ModelAndView mv=new ModelAndView("admission-success");
		//mv.addObject("headerMessage", "Best College of Engineering, India");
		return mv;
	}
	
	/*@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView handleNullPointrException(Exception e) {
		ModelAndView mv=new ModelAndView("GenericException");
		mv.addObject("exceptionType", "NullPointerException");
		System.out.println("NullPointerException occurred:"+e);
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
	}*/
	@ResponseBody
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public ArrayList<Student> getStudents() {
		ArrayList<Student> studentList=new ArrayList<Student>();
		studentList.add(new Student("The Great Khali", "WWE"));
		studentList.add(new Student("The Undertaker", "WWE"));
		studentList.add(new Student("John Cena", "WWE"));
		return studentList;
	}
	
}
