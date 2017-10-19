package com.bdqn.ssm.dao;

import java.util.List;

import com.bdqn.ssm.pojo.Student;

public interface StudentMapper {
	
	public int addStudent(Student student);
	
	public List<Student> findAllStudent();
	
	public Student getByStuNoFindStudent(String stuName);
	
	public Student getByIdFindStudent(String stuNo);

}
