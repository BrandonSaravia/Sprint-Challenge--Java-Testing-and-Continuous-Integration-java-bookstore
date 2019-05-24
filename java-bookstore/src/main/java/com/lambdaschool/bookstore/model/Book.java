package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    private static final Logger logger = LoggerFactory.getLogger(Book.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    private String booktitle;

    private String ISBN;

    private int copy;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private List<Authors> authors = new ArrayList<>();


    public Book() {
    }

    public Book(String booktitle, String ISBN, int copy) {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;

        logger.info("Book accessed");
        logger.debug("created Book with title of: " + this.booktitle + ", ISBN number of " + this.ISBN + ", and copyright date(year) of " + this.copy);
    }


    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }
}
