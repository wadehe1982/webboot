package com.xxx.webboot.repository;

import java.util.List;

import com.xxx.webboot.entity.Student;

public interface StudentQueryDslRepository{
	
	List<Student> findByName(String name);

}
