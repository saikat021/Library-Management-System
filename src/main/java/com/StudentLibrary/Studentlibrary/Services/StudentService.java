package com.StudentLibrary.Studentlibrary.Services;

import com.StudentLibrary.Studentlibrary.Model.Card;
import com.StudentLibrary.Studentlibrary.Model.Student;
import com.StudentLibrary.Studentlibrary.Repositories.CardRepository;
import com.StudentLibrary.Studentlibrary.Repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    Logger logger= LoggerFactory.getLogger(StudentService.class);


    @Autowired
    StudentRepository studentRepository ;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardService cardService;

    public void createStudent (Student student){

        Card card=cardService.createCard(student);
        logger.info("The card for the student{} is created with the card details{}",student,card);


    }
    public int  updateStudent(Student student){
        return studentRepository.updateStudentDetails(student);


    }


    public void deleteStudent(int id ){

        cardService.deactivate(id);
        studentRepository.deleteCustom(id);

    }
}
