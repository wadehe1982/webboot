package com.xxx.webboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xxx.webboot.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
