package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface AuthorsService {

    ArrayList<Authors> findAll(Pageable pageable);

    Authors findAuthorById(long id);
}
