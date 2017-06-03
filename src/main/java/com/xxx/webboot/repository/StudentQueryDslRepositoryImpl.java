package com.xxx.webboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
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

	@Override
	public Page<Student> findByName(String name, PageRequest pageRequest) {
		
		BooleanBuilder builder = new BooleanBuilder();
		if (!StringUtils.isEmpty(name)){
			builder.and(qStudent.name.eq(name));
		}
		
		JPQLQuery<Student> countQuery = from(qStudent).where(builder);
		
		JPQLQuery<Student> query = this.getQuerydsl().applyPagination(pageRequest, countQuery);
		List<Student> total = query.fetch();
		return new PageImpl<>(total, pageRequest, countQuery.fetchCount());
	}


}
