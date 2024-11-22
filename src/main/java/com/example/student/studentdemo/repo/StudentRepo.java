package com.example.student.studentdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.studentdemo.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long > {
    
}
