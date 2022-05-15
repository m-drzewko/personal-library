package com.drzewek.personallibrary.service;

import com.drzewek.personallibrary.model.Author;
import com.drzewek.personallibrary.model.Book;
import com.drzewek.personallibrary.model.Publisher;
import com.drzewek.personallibrary.model.dto.BookSingleAuthorWriteDto;
import com.drzewek.personallibrary.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Book service stores all the logic behind reading and writing content from and to the database,
 * and the validation needed to keep those operations logical
 */
@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;
    private PublisherService publisherService;


    /**
     * This method takes care of creating three different entities from the provided BookSingleAuthor dto
     * by first creating Author and Publisher entities from the provided JSON, saving them to the database,
     * then saving the book entity and assigning associations between the newly saved Book, Author and Publisher
     * @param bookToSave
     * @return Book
     */
    public Book saveBookWithSingleAuthor(BookSingleAuthorWriteDto bookToSave) {
        // create and save new author
        Author newAuthor = new Author(bookToSave.getAuthorFirstName(), bookToSave.getAuthorLastName());
        newAuthor = authorService.saveAuthor(newAuthor);

        // create and save new publisher
        Publisher newPublisher = new Publisher(bookToSave.getPublisherName());
        newPublisher = publisherService.savePublisher(newPublisher);

        // create new book, assign author and publisher to it
        Book newBook = new Book(bookToSave.getTitle());
        newBook.addAuthor(newAuthor);
        newBook.addPublisher(newPublisher);

        // validate if the book exists;
        // if it exists, the new book will not be saved to the DB
        if (identicalBookExists(newBook)) {
            throw new IllegalStateException("This book already exists in the database!");
        } else {
            return bookRepository.save(newBook);
        }
    }

    public Book assignAuthorToBook(Long bookId, Long authorId) {
        Author author = authorService.getAuthor(authorId);
        Book book = bookRepository.getById(bookId);
        book.addAuthor(author);
        return bookRepository.save(book);
    }

    /**
     * Returns the list of all the books that are stored in the DB
     * @return List
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * This method checks if a book that's being newly created already exists in the database.
     * Returns true if the book exists, otherwise returns false
     * @param book
     * @return boolean
     */
    private boolean identicalBookExists(Book book) {
        if(!bookRepository.existsByTitle(book.getTitle())) {
            return false;
        }
        List<Book> potentialDuplicates = bookRepository.findByTitle(book.getTitle()).get();

        for (Book book1 :
                potentialDuplicates) {
            if (book1.getAuthors().hashCode() == book.getAuthors().hashCode() && book1.getPublisher().getName().equals(book.getPublisher().getName())) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
}
