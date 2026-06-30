package com.ganesh.service;

import com.ganesh.dto.StudentDto;
import com.ganesh.entity.Student;

public interface StudentService {
	
	
	String saveStudent(StudentDto studentDto);
	
	Student findStudentById(Integer id);

}
