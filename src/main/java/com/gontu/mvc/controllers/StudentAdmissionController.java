package com.gontu.mvc.controllers;

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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		binder.setDisallowedFields(new String[] {"studentMobile"});
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
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("studentObj")Student stud, BindingResult result ) {
		
		if(result.hasErrors()) {
			ModelAndView mv_errors=new ModelAndView("admission-form");
			return mv_errors;
		}
		ModelAndView mv=new ModelAndView("admission-success");
		//mv.addObject("headerMessage", "Best College of Engineering, India");
		return mv;
	}
}
