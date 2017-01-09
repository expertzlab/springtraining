package com.expertzlab.readbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gireeshbabu on 04/01/17.
 */

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @RequestMapping(value="/{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Isbn isbn){
        return bookRepo.findBookByIsbn(isbn.getIsbn());
    }
}
