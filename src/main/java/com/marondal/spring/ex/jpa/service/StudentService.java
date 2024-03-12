package com.marondal.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.jpa.domain.Student;
import com.marondal.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		
		Student student = Student.builder()
								.name(name)
								.phoneNumber(phoneNumber)
								.email(email)
								.dreamJob(dreamJob)
								.build();
		
		
		student = studentRepository.save(student);
		
		return student;
	}
	
	// 전달된 id와 일치하는 학생 정보중 장래희망을 전달 받은 값으로 수정한다. 
	public Student updateStudent(int id, String dreamJob) {
		// update 대상 행을 조회 한다. 
		// 조회를 통해 얻은 객체의 특정 값을 수정한다. 
		// 수정된 객체를 저장한다. 
		
		// Optional : null 일수 있는 값을 처리하기 위한 객체
		// null에대한 처리 기능이 포함되어 있다.
		// null 이 리턴될 수 있는 메소드의 리턴 타입 
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		student = student.toBuilder()
					.dreamJob(dreamJob)
					.build();
		
		
		student = studentRepository.save(student);
		
		return student;
		
	}
	
	
	public void deleteStudent(int id) {
		
//		studentRepository.deleteById(id);
		// 삭제 대상 행 조회 
		// 객체 기반으로 삭제 
		
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
		
	}
	
	
}
