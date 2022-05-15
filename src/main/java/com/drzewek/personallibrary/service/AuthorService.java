package com.drzewek.personallibrary.service;

import com.drzewek.personallibrary.model.Author;
import com.drzewek.personallibrary.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AuthorService {

    private AuthorRepository authorRepository;

    public boolean checkForAuthor(Author author) {
        return authorRepository.existsByFirstNameAndLastName(author.getFirstName(), author.getLastName());
    }

    public Author saveAuthor(Author authorToSave) {
        if (authorRepository.existsByFirstNameAndLastName(authorToSave.getFirstName(), authorToSave.getLastName())) {
            return authorRepository.findByFirstNameAndLastName(authorToSave.getFirstName(), authorToSave.getLastName()).get();
        } else {
            return authorRepository.save(authorToSave);
        }
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
