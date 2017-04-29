package com.xxx.webboot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xxx.webboot.model.StudentDTO;

public class StudentMapper implements RowMapper<StudentDTO>{

	@Override
	public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentDTO student = new StudentDTO();
		student.setName(rs.getString("name"));
		student.setStudentId(rs.getLong("studentId"));
		return student;
	}

}
