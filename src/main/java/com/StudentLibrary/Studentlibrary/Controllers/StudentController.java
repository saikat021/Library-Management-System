package com.StudentLibrary.Studentlibrary.Controllers;

import com.StudentLibrary.Studentlibrary.Model.Student;
import com.StudentLibrary.Studentlibrary.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;


    @PostMapping("/createStudent")
    public ResponseEntity createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return new ResponseEntity("Student Successfully added to the system", HttpStatus.CREATED);

    }

    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody Student student){
        int lines=studentService.updateStudent(student);
        return new ResponseEntity("Student updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity deleteStudent(@RequestParam("id")int id){
        studentService.deleteStudent(id);
        return new ResponseEntity("student successfully deleted!!",HttpStatus.OK);
    }










}
