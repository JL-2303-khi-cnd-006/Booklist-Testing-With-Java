package com.example.bookdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BookTesting {

    @Test
    void addingTheBook(){
        BookRepo bookRepo = Mockito.mock(BookRepo.class);

        Book book1 = new Book(1, "Javeria", 23);
        Book book2 = new Book(2, "Mher", 23);
        Book book3 = new Book(3, "Fatima", 23);
        
        List<Book> Booklist = new ArrayList<>();        
        Booklist.add(book1);
        Booklist.add(book2);
        Booklist.add(book3);
        
        when(bookRepo.findAll()).thenReturn(Booklist);
        BookController bookController = new BookController(bookRepo);
        List<Book> result = bookController.getTheBooks();
        
        assertEquals(Booklist, result);
    }
    
}
