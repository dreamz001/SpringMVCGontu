package com.gontu.mvc.model;

public class Student {

	private String studentName;
	private String studentHobby;
	
	public Student() {
		super();
	}
	public Student(String studentName, String studentHobby) {
		super();
		this.studentName = studentName;
		this.studentHobby = studentHobby;
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
	
	
	
}
