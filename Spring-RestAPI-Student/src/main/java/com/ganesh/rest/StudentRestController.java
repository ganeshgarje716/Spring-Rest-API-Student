package com.ganesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.dto.StudentDto;
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

}
