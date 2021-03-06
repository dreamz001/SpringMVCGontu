package com.gontu.mvc.model;

import java.util.ArrayList;
import java.util.Date;

public class Student {

	private String studentName;
	private String studentHobby;
	
	private Long studentMobile;
	private Date studentDOB;
	private ArrayList<String> studentSkills;
	
	public Student() {
		super();
	}
	public Student(String studentName, String studentHobby) {
		super();
		this.studentName = studentName;
		this.studentHobby = studentHobby;
	}
	
	public Student(String studentName, String studentHobby, Long studentMobile, Date studentDOB,
			ArrayList<String> studentSkills) {
		super();
		this.studentName = studentName;
		this.studentHobby = studentHobby;
		this.studentMobile = studentMobile;
		this.studentDOB = studentDOB;
		this.studentSkills = studentSkills;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	
	
	
}
