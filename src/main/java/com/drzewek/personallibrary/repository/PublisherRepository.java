package com.drzewek.personallibrary.repository;

import com.drzewek.personallibrary.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    boolean existsByName(String name);

    Optional<Publisher> findByName(String name);
}
