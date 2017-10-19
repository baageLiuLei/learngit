package com.bdqn.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bdqn.ssm.pojo.Student;
import com.bdqn.ssm.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/toAddStudent")
	public String toAddStudent(){
		return "addStudent";
	}
	
//	@RequestMapping("/doAddStudent")
//	public String doAddStudent(Model model,HttpServletRequest request,@RequestParam(value="files") MultipartFile files,Student student){
//		//上传图片
//		String path = request.getSession().getServletContext().getRealPath("upload");
//		path = path.replace("ssm_3", "");
//		if(!files.isEmpty()){
//			//获取文件名
//			String fileName = files.getOriginalFilename();//原文件名
//			//获取后缀名
//			String suffix = FilenameUtils.getExtension(fileName);
//			//将文件名重命名
//			fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"."+suffix;
//			//是不是图片的后缀
//			if(suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png")){
//				File file = new File(path,fileName);
//				if(!file.exists()){
//					file.mkdirs();
//				}
//				//执行上传的操作
//				try {
//					files.transferTo(file);
//				} catch (IllegalStateException | IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			//将文件名保存到Student对象里面
//			student.setZjz(fileName);
//		}
//		//执行保存数据的操作
//		int count = studentService.addStudent(student);
//		if(count>0){
//			model.addAttribute("files", student.getZjz());
//			return "success";
//		}else{
//			return "addStudent";
//		}
//		
//		
//	}
	
	
	@RequestMapping("/doAddStudent")
	public String doAddStudent(Model model,HttpServletRequest request,@RequestParam(value="files") MultipartFile[] files,Student student){
		//图片的名称
		String fileName1 = "";
		String fileName2 = "";
		
		//上传多张图片
		String path = request.getSession().getServletContext().getRealPath("upload");
		path = path.replace("ssm_3", "");
		for(int i=0;i<files.length;i++){
			MultipartFile file = files[i];
			String fileName = file.getOriginalFilename();
			String suffix = FilenameUtils.getExtension(fileName);
			fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"."+suffix;
			if(suffix.equalsIgnoreCase("jpg")||
					suffix.equalsIgnoreCase("png")||
						suffix.equalsIgnoreCase("gif")){
				File f = new File(path,fileName);
				if(!f.exists()){
					f.mkdirs();
				}
				//执行上传图片操作
				try {
					file.transferTo(f);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i==0){
					fileName1 = fileName;
				}else if(i==1){
					fileName2 = fileName;
				}
			}
			student.setZjz(fileName1);
			student.setGzz(fileName2);
		}
		//执行保存数据的操作
		int count = studentService.addStudent(student);
		if(count>0){
			model.addAttribute("files", student.getZjz());
			return "forward:/findAllStudent";
		}else{
			return "addStudent";
		}
	}
	
	@RequestMapping("/findAllStudent")
	public String findAllStudent(Model model){
		List<Student> list = studentService.findAllStudent();
		model.addAttribute("list", list);
		return "studentList";
	}
	
	@RequestMapping("/checkStuName")
	@ResponseBody
	public Object checkStuName(String stuName){
		Student student = studentService.getByStuNoFindStudent(stuName);
		String str="";
		if(student!=null){
			str = "no";
		}else{
			str = "yes";
		}
		return JSONObject.toJSONString(str);
	}
	
	@RequestMapping(value="/getByIdFindStudent",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object getByIdFindStudent(String stuNo){
		Student student = studentService.getByIdFindStudent(stuNo);
		return JSONObject.toJSONString(student);
	}
	
	
	

}
