package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface BookService {

    ArrayList<Book> findAll(Pageable pageable);

    Book update(Book book, long id);

    Book save (Book book);

    void delete(long id);

    Book findBookById(long id);

    void assignBooktoAuthor(long authorid, long bookid);
}
