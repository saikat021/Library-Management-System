package com.StudentLibrary.Studentlibrary.Services;

import com.StudentLibrary.Studentlibrary.Model.Book;
import com.StudentLibrary.Studentlibrary.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBook(Book book){
        bookRepository.save(book);



    }
    //Either giving you all the available books
    //OR gicing you all the non-available books
    public List<Book> getBooks(String genre, boolean isAvailable,String author){

        if (genre!=null&&author!=null){
            return bookRepository.findBooksByGenre_Author(genre,author,isAvailable);
        }
        else if (genre!=null){
            return bookRepository.findBooksByGenre(genre,isAvailable);
        }
        else if (author!=null){
            return bookRepository.findBooksByAuthor(author,isAvailable);
        }
        return bookRepository.findBooksByAvailability(isAvailable);







    }

}
