package com.bdqn.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.ssm.dao.StudentMapper;
import com.bdqn.ssm.pojo.Student;
import com.bdqn.ssm.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.addStudent(student);
	}

	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return studentMapper.findAllStudent();
	}

	@Override
	public Student getByStuNoFindStudent(String stuNo) {
		// TODO Auto-generated method stub
		return studentMapper.getByStuNoFindStudent(stuNo);
	}

	@Override
	public Student getByIdFindStudent(String stuNo) {
		// TODO Auto-generated method stub
		return studentMapper.getByIdFindStudent(stuNo);
	}
	

}
