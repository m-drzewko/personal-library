package com.drzewek.personallibrary.repository;

import com.drzewek.personallibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
