package com.xxx.webboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.webboot.entity.Student;
import com.xxx.webboot.mapper.StudentMapper;
import com.xxx.webboot.model.StudentDTO;
import com.xxx.webboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public Student findById(Long id) {
		Student student = studentRepository.findOne(id);
		return student;
	}

	@Override
	@Transactional
	public Student save(Student student) {
		Student saved = studentRepository.save(student);
		return saved;
	}

	@Override
	@Transactional
	public Iterable<Student> saveList(List<Student> students) {
		Iterable<Student> savedList = studentRepository.save(students);
		return savedList;
	}

	@Override
	@Transactional
	public List<StudentDTO> findByJdbcTemplate() {
		List<StudentDTO> result = jdbcTemplate.query("select * from student", new StudentMapper());
		return result;
	}

	@Override
	@Transactional
	public void testTransaction(Student s1, Student s2) {
		
		Student saved1 = studentRepository.save(s1);
		
		Student saved2 = studentRepository.save(s2);
		
		System.out.println(saved1);
		System.out.println(saved2);
		
	}

}
