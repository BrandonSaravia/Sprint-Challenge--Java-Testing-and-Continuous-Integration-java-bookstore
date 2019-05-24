package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepo extends CrudRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {


    @Modifying
    @Query(value = "DELETE FROM bookauthors WHERE bookid = :bookid", nativeQuery = true)
    void deleteCourseFrombookauthors(long bookid);

    @Query(value = "Insert INTO bookauthors(authorid, bookid) values(:authorid, :bookid)", nativeQuery = true)
    void assignBookToAuthor(long authorid, long bookid);

}
