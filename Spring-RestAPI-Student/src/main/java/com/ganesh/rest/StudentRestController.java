package com.ganesh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.dto.StudentDto;
import com.ganesh.entity.Student;
import com.ganesh.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class StudentRestController {
	
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@Valid @RequestBody StudentDto studentDto) {
		
		String save = studentService.saveStudent(studentDto);
		
		return new ResponseEntity<String>(save,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/student{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable Integer id) {
		
		Student student = studentService.findStudentById(id);
		
		if (student == null) {
			
			return new ResponseEntity<Student>(student, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> findAllStudents() {
		
		List<Student> all = studentService.findAllStudents();
		
		return new ResponseEntity<List<Student>>(all, HttpStatus.OK);
	}
	
	
	
	@PutMapping("/update{id}")
	public ResponseEntity<String> updateStudentById(@PathVariable Integer id, @RequestBody Student student){
		
		String update = studentService.updateStudentById(id, student);
		
		return new ResponseEntity<String>(update, HttpStatus.OK);
	}
	
	
	
	public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) {
		
		String delete = studentService.deleteById(id);
		
		return new ResponseEntity<String>(delete, HttpStatus.OK);
	}

}
