package com.gontu.mvc.controllers.rest;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gontu.mvc.model.Student;

@RestController
@RequestMapping("/rest")
public class StudentRestController {

	@RequestMapping(value="/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public ArrayList<Student> getStudents() {
		ArrayList<Student> studentList=getStudentList();
		return studentList;
	}
	
	@RequestMapping(value="/students/{name}", method = RequestMethod.GET)
	public Student getStudentDetails(@PathVariable("name")String studentName) {
		ArrayList<Student> studentList=getStudentList();
		for(Student student:studentList) {
			if(studentName.equalsIgnoreCase(student.getStudentName())) {
				return student;
			}
		}
		return null;
	}
	
	private ArrayList<Student> getStudentList() {
		ArrayList<Student> studentList=new ArrayList<Student>();
		studentList.add(new Student("The Great Khali", "WWE"));
		studentList.add(new Student("The Undertaker", "WWE"));
		studentList.add(new Student("John Cena", "WWE"));
		studentList.add(new Student("Sachin Tendulkar", "Cricket"));
		studentList.add(new Student("Yuvraj Singh", "Cricket"));
		studentList.add(new Student("Virat Kohli", "Cricket"));
		return studentList;
	}
}
