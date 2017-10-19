package com.bdqn.ssm.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



public class Student {
	
	private String stuNo;
	private String stuName;
	private String gradeId;
	private int age;
	private String passWord;
	private String birthday;
	private String zjz;//证件照
	private String gzz;//工作照
	
	
	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getZjz() {
		return zjz;
	}

	public void setZjz(String zjz) {
		this.zjz = zjz;
	}

	public String getGzz() {
		return gzz;
	}

	public void setGzz(String gzz) {
		this.gzz = gzz;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	

	

	
	
	

}
