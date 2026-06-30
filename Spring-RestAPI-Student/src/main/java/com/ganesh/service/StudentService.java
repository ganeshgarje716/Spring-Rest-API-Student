package com.ganesh.service;

import java.util.List;

import com.ganesh.dto.StudentDto;
import com.ganesh.entity.Student;

public interface StudentService {
	
	
	String saveStudent(StudentDto studentDto);
	
	Student findStudentById(Integer id);
	
	List<Student> findAllStudents();
	
	String updateStudentById(Integer id, Student student); 

}
