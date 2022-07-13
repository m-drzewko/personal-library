package com.drzewek.personallibrary.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Set<Author> authors = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private Status status = Status.NEW;

    public Publisher addPublisher(Publisher newPublisher) {
        publisher = newPublisher;
        return publisher;
    }

    public Set<Author> addAuthor(Author newAuthor) {
        authors.add(newAuthor);
        return authors;
    }

    public Book(String title, Set<Author> authors, Publisher publisher) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
    }

    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (authors != null ? !authors.equals(book.authors) : book.authors != null) return false;
        return publisher != null ? publisher.equals(book.publisher) : book.publisher == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", publisher=" + publisher +
                ", status=" + status +
                '}';
    }
}
