package com.drzewek.personallibrary.service;

import com.drzewek.personallibrary.model.Author;
import com.drzewek.personallibrary.model.dto.AuthorWriteDto;
import com.drzewek.personallibrary.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AuthorService {

    private AuthorRepository authorRepository;

    public boolean checkForAuthor(Author author) {
        return authorRepository.existsByFirstNameAndLastName(author.getFirstName(), author.getLastName());
    }

    public Author saveAuthor(AuthorWriteDto authorToSave) {
        Author toSave = new Author(authorToSave.getFirstName(), authorToSave.getLastName());

        if (authorRepository.existsByFirstNameAndLastName(toSave.getFirstName(), toSave.getLastName())) {
            return authorRepository.findByFirstNameAndLastName(toSave.getFirstName(), toSave.getLastName()).get();
        } else {
            return authorRepository.save(toSave);
        }
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

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
