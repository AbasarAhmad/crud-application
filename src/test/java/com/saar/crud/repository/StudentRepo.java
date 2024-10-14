package com.saar.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saar.crud.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
