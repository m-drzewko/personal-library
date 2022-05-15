package com.drzewek.personallibrary.controller;

import com.drzewek.personallibrary.model.Book;
import com.drzewek.personallibrary.model.dto.AuthorWriteDto;
import com.drzewek.personallibrary.model.dto.BookSingleAuthorWriteDto;
import com.drzewek.personallibrary.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

//    @PostMapping("/save")
//    ResponseEntity<Book> saveAuthor(@RequestBody AuthorWriteDto author) {
//        return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
//    }

}
