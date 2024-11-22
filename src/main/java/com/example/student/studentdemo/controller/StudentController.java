package com.example.student.studentdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.studentdemo.entity.Student;
import com.example.student.studentdemo.repo.StudentRepo;


@RestController
public class StudentController {
    // @Autowired StudentService studentService;
    @Autowired
    StudentRepo studentRepo;
    @PostMapping("/api/students")
    
     public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentRepo.save(student),HttpStatus.CREATED);


    }
    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> getStudent(){
        return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);


    }
    @GetMapping("/api/students/{rollno}")
    public ResponseEntity<Student> getStudent(@PathVariable long rollno){
        Optional<Student> student =studentRepo.findById(rollno);
        if (student.isPresent()){
            return new ResponseEntity<>(student.get(),HttpStatus.OK);
        }
        else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @PutMapping("/api/students/{rollno}")
    public ResponseEntity<Student> updateStudent(@PathVariable long rollno,@RequestBody Student stud){
        Optional<Student> student =studentRepo.findById(rollno);
        if (student.isPresent()){
            student.get().setName(stud.getName());
            student.get().setSection(stud.getSection());
            return new ResponseEntity<>(studentRepo.save(student.get()),HttpStatus.OK);
        }
        else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @DeleteMapping("/api/students/{rollno}")
    public ResponseEntity<Void> delStudent(@PathVariable long rollno)
    {
        Optional<Student> student =studentRepo.findById(rollno);
        if (student.isPresent()){
            studentRepo.deleteById(rollno);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    
//     public void saveStudentDetails(@RequestBody Student student) {
//     studentService.saveStudent(student);
//     }
   
//    public void getStudentDetails () {
//         studentService.getStudent();
//    }
   
   
}
