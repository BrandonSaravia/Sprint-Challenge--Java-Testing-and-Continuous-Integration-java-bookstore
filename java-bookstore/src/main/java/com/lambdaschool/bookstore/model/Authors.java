package com.lambdaschool.bookstore.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Authors extends Auditable{

    private static final Logger logger = LoggerFactory.getLogger(Authors.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid ;

    private String lastname;

    private String firstname;

    @ManyToMany
    @JoinTable(name = "bookauthors", joinColumns = {@JoinColumn(name = "authorid")}, inverseJoinColumns = {@JoinColumn(name = "bookid")})
//    @JsonIgnoreProperties("authors")
    private List<Book> books = new ArrayList<>();


    public Authors() {
    }

    public Authors(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;

        logger.info("Authors accessed");
        logger.debug("created Author with name of: " + this.firstname + this.lastname);
    }


    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
