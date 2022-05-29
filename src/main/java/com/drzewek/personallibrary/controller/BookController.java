package com.drzewek.personallibrary.controller;

import com.drzewek.personallibrary.model.Book;
import com.drzewek.personallibrary.model.dto.BookSingleAuthorWriteDto;
import com.drzewek.personallibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @PostMapping("/save")
    ResponseEntity<Book> saveBookWithSingleAuthor(@RequestBody BookSingleAuthorWriteDto book) {
        return new ResponseEntity<>(bookService.saveBookWithSingleAuthor(book), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{bookId}/addAuthor/{authorId}")
    ResponseEntity<Book> assignAuthorToBook(@PathVariable Long bookId, @PathVariable Long authorId) {
        return new ResponseEntity<>(bookService.assignAuthorToBook(bookId, authorId), HttpStatus.OK);
    }

//    @GetMapping("/get/{firstName}/{lastName}")
//    ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String firstName, @PathVariable String lastName) {
//        return new ResponseEntity<>(bookService.findBookByAuthor(firstName, lastName), HttpStatus.ACCEPTED);
//    }

    // does not seem to work correctly, returns nothing
//    @GetMapping("/getTitled")
//    ResponseEntity<List<Book>> getBooksByTitleContaining(@RequestBody String title) {
//        return new ResponseEntity<>(bookService.getBooksByTitleContaining(title), HttpStatus.ACCEPTED);
//    }
}
