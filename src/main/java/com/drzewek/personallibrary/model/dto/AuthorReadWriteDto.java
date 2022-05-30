package com.drzewek.personallibrary.model.dto;

import lombok.Getter;

@Getter
public class AuthorReadWriteDto {
    /**
     * This Author DTO is used to save an author to the repository
     */
    private String firstName;
    private String lastName;
}
