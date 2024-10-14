package com.saar.crud.service;

import java.util.List;

import com.saar.crud.payloads.StudentDto;


public interface StudentService {
    StudentDto addStudent(StudentDto studentDto);
    StudentDto getStudentById(Integer sId);
    StudentDto DeleteStudent(Integer sId);
    List<StudentDto> getAllStudent();
    StudentDto updateStudent(StudentDto studentDto,Integer sId);
}
	
	
	
	
	
	
	
	