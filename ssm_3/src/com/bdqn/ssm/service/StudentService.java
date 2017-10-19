package com.bdqn.ssm.service;

import java.util.List;

import com.bdqn.ssm.pojo.Student;

public interface StudentService {
	
	public int addStudent(Student student);
	
	public List<Student> findAllStudent();

	public Student getByStuNoFindStudent(String stuNo);
	
	public Student getByIdFindStudent(String stuNo);
}
