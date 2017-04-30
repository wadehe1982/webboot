package com.xxx.webboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.ImmutableList;
import com.xxx.webboot.entity.Student;
import com.xxx.webboot.model.StudentDTO;
import com.xxx.webboot.model.UserDTO;
import com.xxx.webboot.service.StudentService;

@Controller
public class FirstController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private UserDTO userDTO;

	@RequestMapping("test")
	@ResponseBody
	public String test() {
		
		System.out.println(userDTO);
		
		List<StudentDTO> lists = studentService.findByJdbcTemplate();
		
		System.out.println(lists);
		
		Student id1 = studentService.findById(1L);
		
		id1.setName("xxx");
		
		System.out.println(id1);
		
		Student student = new Student();
		student.setName("test_name");
		
		Student saved = studentService.save(student);
		
		System.out.println(saved);
		
		Student student1 = new Student();
		student1.setName("test_name1");
		
		Iterable<Student> savedList = studentService.saveList(ImmutableList.of(student1));
		
		System.out.println(savedList);
		
		Student student3 = new Student();
		student3.setName("3x");
		
		Student student4 = new Student();
		
		studentService.testTransaction(student3, student4);

		return "xxx";
	}

}
