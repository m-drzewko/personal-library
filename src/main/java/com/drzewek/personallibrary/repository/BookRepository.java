package com.drzewek.personallibrary.repository;

import com.drzewek.personallibrary.model.Author;
import com.drzewek.personallibrary.model.Book;
import com.drzewek.personallibrary.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    boolean existsByTitle(String title);

    Optional<List<Book>> findByTitle(String title);

    boolean existsByPublisher(String name);
}