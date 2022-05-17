package com.drzewek.personallibrary.controller;

import com.drzewek.personallibrary.model.Author;
import com.drzewek.personallibrary.model.Book;
import com.drzewek.personallibrary.model.dto.AuthorWriteDto;
import com.drzewek.personallibrary.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @GetMapping("/get")
    ResponseEntity<List<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.ACCEPTED);
    }
    @PostMapping("/save")
    ResponseEntity<Author> saveAuthor(@RequestBody AuthorWriteDto author) {
        return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
    }



}
