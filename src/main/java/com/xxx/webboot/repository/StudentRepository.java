package com.xxx.webboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxx.webboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
//public interface StudentRepository extends CrudRepository<Student, Long> {
}
