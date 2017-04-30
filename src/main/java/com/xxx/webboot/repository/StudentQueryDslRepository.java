package com.xxx.webboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.xxx.webboot.entity.Student;

public interface StudentQueryDslRepository{
	
	List<Student> findByName(String name);

	Page<Student> findByName(String name, PageRequest pageRequest);
}
