package com.saar.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saar.crud.payloads.ApiResponse;
import com.saar.crud.payloads.DeleteStudentApi;
import com.saar.crud.payloads.StudentDto;
import com.saar.crud.service.StudentService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/student/")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
//	@PostMapping("/add")
//	public ResponseEntity<StudentDto> addStudent(@Valid @RequestBody StudentDto studentDto)
//	{
//		StudentDto st=this.studentService.addStudent(studentDto);
//		return new ResponseEntity<StudentDto>(st,HttpStatus.CREATED);
//		
//	}
	@PostMapping("/add")
	public StudentDto addStudent(@Valid @RequestBody StudentDto studentDto)
	{
		StudentDto st=this.studentService.addStudent(studentDto);
		return st;		
	}
	
	@GetMapping("/get/{id}")
	public StudentDto getStudentById(	@PathVariable("id") Integer sId)
	{
		return this.studentService.getStudentById(sId);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<StudentDto,ApiResponse> deleteStudent(@PathVariable("id") Integer sId)
//	{
//		StudentDto sd=this.studentService.DeleteStudent(sId);
//		ApiResponse apiResponse=new ApiResponse("Student is deleted",true);
//		return new ResponseEntity<StudentDto,ApiResponse>(sd,apiResponse,HttpStatus.OK);
//	}
	
//           OR
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DeleteStudentApi> deleteStudent(@PathVariable("id") Integer sId)
	{
		StudentDto sd=this.studentService.DeleteStudent(sId);
		ApiResponse apiResponse=new ApiResponse("Student is deleted",true);
		DeleteStudentApi di=new DeleteStudentApi(sd,apiResponse);
		return new ResponseEntity<DeleteStudentApi>(di,HttpStatus.OK);
	}
	
	
	// get All Students
	
	@GetMapping("/get")
	public ResponseEntity<List<StudentDto>> getAllStudent()
	{
		List <StudentDto> lt=this.studentService.getAllStudent();
		return new ResponseEntity<List<StudentDto>>(lt,HttpStatus.OK);
	}
	
	
	// Update Student
	@PutMapping("/update/{id}")
	public ResponseEntity<StudentDto>UpdateStudent(@Valid @RequestBody StudentDto studentDto,@PathVariable Integer id)
	{
		StudentDto sd=this.studentService.updateStudent(studentDto, id);
		return new ResponseEntity<StudentDto>(sd,HttpStatus.OK);
	}
}
