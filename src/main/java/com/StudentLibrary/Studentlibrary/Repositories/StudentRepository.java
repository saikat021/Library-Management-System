package com.StudentLibrary.Studentlibrary.Repositories;

import com.StudentLibrary.Studentlibrary.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //JPQL-->Java persistence Query language-->(Objects and Attributes)
    //Native sql query-->(columns and tables)


    @Modifying
    @Query("update Student s set s.emailId=:newEmail where s.emailId=:oldEmail")
    int updateStudentEmail(@Param("oldEmail") String oldEmail,@Param("newEmail") String newEmail);


    @Modifying
    @Query("delete from Student s where s.id=:id ")
    int deleteCustom(@Param("id") int id);


    @Modifying
    @Query("update Student s set s.emailId= :#{#student.emailId}," +
            "s.name=:#{#student.name}," +
            "s.age=:#{#student.age}," +
            "s.country=:#{#student.country} where s.id=:#{#student.id}")
    int updateStudentDetails(@Param("student") Student student);

    //find student by given name
    //Terminal---> Select * from student where email =email
    //1. JPQL--Dealing with java objects
    //Student(exact class name) class has the variable name as emailId so b.emailId
    // :mail has to passed in the argument of the function exact variable name as in the args

    @Query("select b from Student b where b.emailId=: mail")
    List<Student> find_by_mail(String mail);

    //Native sql query -- dealing with sql tables
    //SQL table formed with name student not Student
    //if the variable name is emailId then parameter used in query is email_id
    //Hibernate converts camel case to _ separated names
    //Think of it as a sql table


    @Query(value = "select * from student s where s.email_id=:mail",nativeQuery = true)
    List<Student> findbymail(String mail);


}
