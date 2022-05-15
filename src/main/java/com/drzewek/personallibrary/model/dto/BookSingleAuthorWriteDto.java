package com.drzewek.personallibrary.model.dto;

import lombok.Getter;

@Getter
public class BookSingleAuthorWriteDto {

    /**
     * This Book DTO stores information about a book with a single author
     * for the purpose of saving a book with an author right away
     * instead of creating both separately and then assigning one to another
     *
     * Note that for books with multiple authors that is still the case
     */

    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String publisherName;


}
