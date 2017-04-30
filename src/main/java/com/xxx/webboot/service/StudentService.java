package com.xxx.webboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.xxx.webboot.entity.Student;
import com.xxx.webboot.model.StudentDTO;

public interface StudentService {

	Student findById(Long id);
	
	Student save(Student student);
	
	Iterable<Student> saveList(List<Student> students);
	
	List<StudentDTO> findByJdbcTemplate();
	
	void testTransaction(Student s1, Student s2);
	
	Page<Student> findByName(String name, PageRequest pageRequest);
	
	List<Student> findByName(String name);
}
