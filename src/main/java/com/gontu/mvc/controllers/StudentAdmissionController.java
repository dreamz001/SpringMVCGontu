package com.gontu.mvc.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gontu.mvc.model.Student;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admission-form", method = RequestMethod.GET)
	public ModelAndView displayAdmissionForm() {
		ModelAndView mv=new ModelAndView("admission-form");
		//mv.addObject("headerMessage", "Best College of Engineering, India");
		return mv;
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
	public ModelAndView submitAdmissionForm(@ModelAttribute("studentObj")Student stud ) {
		ModelAndView mv=new ModelAndView("admission-success");
		//mv.addObject("headerMessage", "Best College of Engineering, India");
		return mv;
	}
}
