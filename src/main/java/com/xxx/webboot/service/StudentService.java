package com.xxx.webboot.service;

import java.util.List;

import com.xxx.webboot.entity.Student;
import com.xxx.webboot.model.StudentDTO;

public interface StudentService {

	Student findById(Long id);
	
	Student save(Student student);
	
	Iterable<Student> saveList(List<Student> students);
	
	List<StudentDTO> findByJdbcTemplate();
	
	void testTransaction(Student s1, Student s2);
}
