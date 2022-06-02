package com.drzewek.personallibrary.controller;

import com.drzewek.personallibrary.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/publishers")
public class PublisherController {

    private PublisherService publisherService;



}
