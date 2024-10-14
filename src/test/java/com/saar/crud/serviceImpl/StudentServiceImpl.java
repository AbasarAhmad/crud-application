package com.saar.crud.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saar.crud.entity.Student;
import com.saar.crud.exceptions.ResourceNotFoundException;
import com.saar.crud.payloads.StudentDto;
import com.saar.crud.repository.StudentRepo;
import com.saar.crud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	 @Autowired
	    private StudentRepo studentRepo;
	    
	    @Override
	    public StudentDto addStudent(StudentDto studentDto) {
	        Student student = dtoToStudent(studentDto);
	        Student addedStudent = studentRepo.save(student);
	        return studentToDto(addedStudent);
	    }

	    @Override
	    public StudentDto getStudentById(Integer sId) {
	        Student student = this.studentRepo.findById(sId)
	            .orElseThrow(() -> new ResourceNotFoundException("Student", "id", sId));
	        return studentToDto(student);
	    }

	    @Override
	    public StudentDto DeleteStudent(Integer sId) {
	        Student student = this.studentRepo.findById(sId)
	            .orElseThrow(() -> new ResourceNotFoundException("Student", "id", sId));
	        this.studentRepo.delete(student);
	        return studentToDto(student);
	    }

	    @Override
	    public List<StudentDto> getAllStudent() {
	        List<Student> lt = studentRepo.findAll();
	        return lt.stream().map(this::studentToDto).collect(Collectors.toList());
	    }

	    @Override
	    public StudentDto updateStudent(StudentDto studentDto,Integer sId) {
	    	Student student=this.studentRepo.findById(sId).orElseThrow(()->new ResourceNotFoundException("User","id",sId));
	    	Student st=dtoToStudent(studentDto);
	    	student.setName(st.getName());
	    	student.setEmail(st.getEmail());
	    	student.setPhone(st.getPhone());
	    	student.setSalary(st.getSalary());
	    	Student ss=studentRepo.save(student);
	    	return studentToDto(ss);
	    	
	    }
	    
	    
	    private Student dtoToStudent(StudentDto studentDto) {
	        Student student = new Student();
	        student.setName(studentDto.getName());
	        student.setGender(studentDto.getGender());
	        student.setPhone(studentDto.getPhone());
	        student.setEmail(studentDto.getEmail());
	        student.setSalary(studentDto.getSalary());
	        return student;
	    }

	    private StudentDto studentToDto(Student st) {
	        StudentDto sD = new StudentDto();
	        sD.setId(st.getId());
	        sD.setName(st.getName());
	        sD.setGender(st.getGender());
	        sD.setPhone(st.getPhone());
	        sD.setEmail(st.getEmail());
	        sD.setSalary(st.getSalary());
	        return sD;
	    }

}
