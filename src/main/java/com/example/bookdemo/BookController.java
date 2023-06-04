package com.example.bookdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/book")
public class BookController {
    
    private BookRepo bookRepo;

    public BookController(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    @PostMapping("/add")
    public String addTheBook(@RequestBody Book book){
        bookRepo.save(book);
        return "Success";
    }

    @GetMapping("/all")
    public List<Book> getTheBooks(){
        return bookRepo.findAll();
    }
    
    @GetMapping("/get")
    public Optional<Book> getById(@PathParam(value = "{id}") int id){
        return bookRepo.findById(id);
    }
}
