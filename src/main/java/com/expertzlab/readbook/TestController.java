package com.expertzlab.readbook;

import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gireeshbabu on 24/01/17.
 */

@RequestMapping("/test")
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/mymethod")
    public Book testMethod(@RequestBody Book reqBook){

        logger.debug("Book details 0- " + reqBook.getReader());

        Book  book = new Book();
        book.setId((long)1);
        book.setAuthor("My Name");
        book.setReader("My Reader");
        return book;
    }
}
