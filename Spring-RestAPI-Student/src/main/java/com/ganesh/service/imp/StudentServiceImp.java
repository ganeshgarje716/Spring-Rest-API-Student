package com.ganesh.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.dto.StudentDto;
import com.ganesh.entity.Student;
import com.ganesh.repository.StudentRepository;
import com.ganesh.service.StudentService;

@Service
public class StudentServiceImp implements StudentService{
	
	
	@Autowired
	StudentRepository studentRepository;
	

	@Override
	public String saveStudent(StudentDto studentDto) {
		
		Student entity=new Student();
		
		entity.setName(studentDto.getName());
		entity.setAddress(studentDto.getAddress());
		entity.setAge(studentDto.getAge());
		entity.setEmail(studentDto.getEmail());
		entity.setMobileNo(studentDto.getMobileNo());
		
		studentRepository.save(entity);
		
		return "Student Save Success";
	}

}
