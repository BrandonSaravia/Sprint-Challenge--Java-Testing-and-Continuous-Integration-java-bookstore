package com.lambdaschool.bookstore.controller;


import com.lambdaschool.bookstore.exception.ResourceNotFoundException;
import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.service.AuthorsService;
import com.lambdaschool.bookstore.service.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/authors")
public class AuthorsController {

    private static final Logger logger = LoggerFactory.getLogger(Authors.class);

    @Autowired
    private AuthorsService authorsService;

    @ApiOperation(value = "return a list of courses, supports pagination", response = Authors.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "specifies the page that you want to access"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "specifies the page size"),
            @ApiImplicitParam(name = "sort", dataType = "string", allowMultiple = true, paramType = "query", value = "Sorts result [name, address, etc]")
    })
    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?> listAllAuthors(@PageableDefault(page = 0, size = 10) Pageable pageable)
    {

        ArrayList<Authors> myAuthors = authorsService.findAll(pageable);

        if (myAuthors == null) {
            throw new ResourceNotFoundException("no students found");
        } else{
            logger.info("/courses accessed");
        }

        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }

}
