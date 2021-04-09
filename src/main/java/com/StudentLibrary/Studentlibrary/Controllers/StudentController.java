package com.StudentLibrary.Studentlibrary.Controllers;

import com.StudentLibrary.Studentlibrary.Model.Student;
import com.StudentLibrary.Studentlibrary.Security.User;
import com.StudentLibrary.Studentlibrary.Security.UserService;
import com.StudentLibrary.Studentlibrary.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;


    @GetMapping("/all")
    public ResponseEntity getAllStudent() {
        List<Student> students=studentService.getAllStudent();
        return new ResponseEntity(students,HttpStatus.OK);
    }
    @GetMapping("/findById")
    public ResponseEntity getStudentById(@RequestParam("id") int id ){
        Student student= studentService.getById(id );
        return new ResponseEntity(student,HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity getStudent(){
        Principal principal=(Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=principal.getName();
       Student student = studentService.getStudentByUsername(username);
       return new ResponseEntity(student,HttpStatus.OK);
    }
    @PostMapping("/createStudent")
    public ResponseEntity createStudent(@RequestBody Student student){

        studentService.createStudent(student);
        //We use the email id as the username and the password as pass123
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        User user=User
                .builder()
                .password(bCryptPasswordEncoder.encode("pass123"))
                .username(student.getEmailId())
                .authority("STUDENT")
                .build();
        userService.saveUser(user);

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
