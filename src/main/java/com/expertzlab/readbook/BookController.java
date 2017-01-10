package com.expertzlab.readbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by gireeshbabu on 04/01/17.
 */

@Controller
@RequestMapping("/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);
    private MyProperties properties;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    public BookController(MyProperties properties){
        this.properties = properties;
    }

    @RequestMapping(value="/{isbn}", method = RequestMethod.GET)
    public String getBook(@PathVariable Isbn isbn, Model model){
        logger.debug("Getting Id configured " + properties.getStudentId());
        Book book = bookRepo.findBookByIsbn(isbn.getIsbn());
        model.addAttribute("book",book);
        return "bookview";
    }

    @RequestMapping(value ="/{isbn}/reviewers", method = RequestMethod.GET)
    public List<Reviewer> getReviewers(@PathVariable("isbn") Book book){
        return book.getReviewers();
    }


}
