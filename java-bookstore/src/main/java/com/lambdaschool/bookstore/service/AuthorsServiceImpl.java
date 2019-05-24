package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.repository.AuthorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "authorsService")
public class AuthorsServiceImpl implements AuthorsService{

    @Autowired
    private AuthorsRepo authorsRepo;

    @Override
    public ArrayList<Authors> findAll(Pageable pageable) {
        ArrayList<Authors> list = new ArrayList<>();
        authorsRepo.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Authors findAuthorById(long id) {
        return authorsRepo.findById(id).get();
    }
}
