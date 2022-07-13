package com.drzewek.personallibrary.controller;

import com.drzewek.personallibrary.model.Author;
import com.drzewek.personallibrary.model.Book;
import com.drzewek.personallibrary.model.dto.AuthorReadWriteDto;
import com.drzewek.personallibrary.model.dto.BookSingleAuthorWriteDto;
import com.drzewek.personallibrary.service.AuthorService;
import com.drzewek.personallibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

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

    @GetMapping("/getbyauthor")
    ResponseEntity<List<Book>> getBooksByAuthor(@RequestBody AuthorReadWriteDto author) {
        Author authorToFind = authorService.getAuthorByNameAndLastName(author.getFirstName(), author.getLastName());
        return new ResponseEntity<>(authorToFind.getBooks()
                .stream()
                .collect(Collectors.toList()),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/toggle")
    ResponseEntity<Book> toggleBookStatus(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.toggleStatus(id), HttpStatus.ACCEPTED);
    }

}
