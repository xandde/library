package com.example.backend.controller;

import com.example.Projeto.model.Book;
import com.example.Projeto.repository.BookRepository;
import com.example.Projeto.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping
    public List<Book> list() { return service.findAll(); }
    @GetMapping("/{id}") public Book one(@PathVariable Long id) { return
            service.findById(id).orElseThrow(); }
    @PostMapping
    public Book create(@RequestBody Book b) { return service.save(b); }
    @PutMapping("/{id}") public Book update(@PathVariable Long id, @RequestBody Book b) { b.setId(id);
        return service.save(b); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}