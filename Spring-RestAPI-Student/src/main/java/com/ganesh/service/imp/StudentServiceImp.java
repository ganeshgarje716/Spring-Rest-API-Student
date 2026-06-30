package com.ganesh.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.dto.StudentDto;
import com.ganesh.entity.Student;
import com.ganesh.exception.StudentNotFoundException;
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


	@Override
	public Student findStudentById(Integer id) {
		
		Optional<Student> byId = studentRepository.findById(id);
		
		if (byId.isPresent()) {
			
			Student student= byId.get();
			
			return student;
		}
		
		throw new StudentNotFoundException("Student Not Found For Id = "+id);
	}


	@Override
	public List<Student> findAllStudents() {

        List<Student> all = studentRepository.findAll();
		
		return all;
	}


	@Override
	public String updateStudentById(Integer id, Student student) {

		Optional<Student> byId = studentRepository.findById(id);
		
		if (byId.isPresent()) {
			
			Student existing = byId.get();
			
			existing.setName(student.getName());
			existing.setAddress(student.getAddress());
			existing.setAge(student.getAge());
			existing.setEmail(student.getEmail());
			existing.setMobileNo(student.getMobileNo());
			
			studentRepository.save(existing);
			
			return "Student Update Success";
		}
		
		throw new StudentNotFoundException("Student Not Found For Id = "+id);
	}


	@Override
	public String deleteById(Integer id) {
		
		if (studentRepository.existsById(id)) {
			
			studentRepository.deleteById(id);
			
			return "Deleted Success";
		}

		throw new StudentNotFoundException("Student Not Found For Id = "+id);
	}

	
	
}
