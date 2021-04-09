package com.StudentLibrary.Studentlibrary;

import com.StudentLibrary.Studentlibrary.Repositories.AuthorRepository;
import com.StudentLibrary.Studentlibrary.Repositories.BookRepository;
import com.StudentLibrary.Studentlibrary.Repositories.CardRepository;
import com.StudentLibrary.Studentlibrary.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentLibraryApplication implements CommandLineRunner {



	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;


	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentLibraryApplication.class, args);
		//User 1 --> Username saikat password -->saikat123($2a$10$P5j63NyMx9hDKgeCGdBnkOjuEqhbPoyFnLAnZ8yaac9wFRZJYeSpm)
		// authority--> STUDENT
		//User2 --> username ananda password --> ananda123($2a$10$XCqqu8qsrqidvamgzZvExuB0NFDsOA.zNzLZ07/zB7ZxusEvuOvvW)
		// authority-->ADMIN
//		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//		System.out.println(bCryptPasswordEncoder.encode("saikat123"));
//		System.out.println(bCryptPasswordEncoder.encode("ananda123"));
	}

	@Override
	public void run(String... args)throws Exception {

//		Student student =new Student("abc@gnail.com","saikat",21,"India");
//
//		Card card=new Card();
//		card.setStudent(student);//Mainly providing you with a two ways relationship
//		student.setCard(card);
//
//		cardRepository.save(card);
//		studentRepository.updateStudentEmail("abc@gnail.com","abc@1234");
//
//		Author author=new Author("Saikat","sai@gmail.com",56,"India");
//		Book book=new Book("Intro to Physics", Genre.PHYSICS,author);
//		author.setBooks_written(Arrays.asList(book));
//		authorRepository.save(author);
//		cardRepository.findAll().stream().forEach(System.out::println);


		//Saving the parent automatically saves the student


	}
}
