package com.xxx.webboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.xxx.webboot.entity.QStudent;
import com.xxx.webboot.entity.Student;


@Repository
public class StudentQueryDslRepositoryImpl extends QueryDslRepositorySupport 
implements StudentQueryDslRepository{
	
	QStudent qStudent = QStudent.student;

	public StudentQueryDslRepositoryImpl() {
		super(StudentQueryDslRepositoryImpl.class);
	}

	@Override
	public List<Student> findByName(String name) {
		return from(qStudent).where(qStudent.name.eq(name)).fetch();
	}

}
