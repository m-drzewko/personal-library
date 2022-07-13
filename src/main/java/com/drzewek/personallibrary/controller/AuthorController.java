package com.drzewek.personallibrary.controller;

import com.drzewek.personallibrary.model.Author;
import com.drzewek.personallibrary.model.dto.AuthorReadWriteDto;
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
    ResponseEntity<Author> saveAuthor(@RequestBody AuthorReadWriteDto author) {
        return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.ACCEPTED);
    }

}
