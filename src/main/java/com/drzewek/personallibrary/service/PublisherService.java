package com.drzewek.personallibrary.service;

import com.drzewek.personallibrary.model.Publisher;
import com.drzewek.personallibrary.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PublisherService {

    private PublisherRepository publisherRepository;

    public Publisher savePublisher(Publisher publisherToSave) {
        if (publisherRepository.existsByName(publisherToSave.getName())) {
            return publisherRepository.findByName(publisherToSave.getName()).get();
        } else {
            return publisherRepository.save(publisherToSave);
        }
    }

    public Publisher getPublisher(Long id) {
        return publisherRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
