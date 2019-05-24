package com.lambdaschool.bookstore.service;


import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepo bookRepo;

    @Override
    public ArrayList<Book> findAll(Pageable pageable) {
        ArrayList<Book> list = new ArrayList<>();
        bookRepo.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public Book update(Book book, long id) {
        Book currentStudent = bookRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (book.getBooktitle() != null) {
            currentStudent.setBooktitle(book.getBooktitle());
        }
        if (book.getISBN() != null) {
            currentStudent.setISBN(book.getISBN());
        }
        if (book.getCopy() != 0) {
            currentStudent.setCopy(book.getCopy());
        }

        return bookRepo.save(currentStudent);
    }

    @Transactional
    @Override
    public Book save(Book book)
    {
        Book newBook = new Book();

        newBook.setBooktitle(book.getBooktitle());
        newBook.setISBN(book.getISBN());
        newBook.setCopy(book.getCopy());

        return bookRepo.save(newBook);
    }

    @Transactional
    @Override
    public void delete(long id) {
        if (bookRepo.findById(id).isPresent()) {
            bookRepo.delete(findBookById(id));
            bookRepo.deleteCourseFrombookauthors(id);
        } else {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Book findBookById(long id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public void assignBooktoAuthor(long authorid, long bookid) {
        bookRepo.assignBookToAuthor(authorid, bookid);
    }
}
