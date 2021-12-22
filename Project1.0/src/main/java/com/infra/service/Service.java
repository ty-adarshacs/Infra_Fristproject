package com.infra.service;

import java.util.List;

import com.infra.entity.Student;


public interface Service {
   
	public Student addStudentRecord(Student s1);
	public Object deleteStudentRecord(int i);
	public Student getstudentById(int i);
	public List<Student> getListOfStudent();
	public Student updateStudentRecord(Student student);
}
