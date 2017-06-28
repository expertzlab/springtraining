package com.expertzlab.readbook;

import ch.qos.logback.classic.spi.LoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by gireeshbabu on 13/12/16.
 */

@Controller
@RequestMapping("/read")
public class ReadingListController {

    private Logger backlogger = LoggerFactory.getLogger(ReadingListController.class);

    private ReadingListRepo repo;
    @Autowired
    private LogAssociated logger;

    @Autowired
    private SpecialLogAssociated spLogger;

    @Autowired
    public ReadingListController(ReadingListRepo repo){
        this.repo = repo;
    }

    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readersBook(@PathVariable("reader") String reader, Model model){
        List<Book> bookList = repo.findByReader(reader);
        if(bookList != null){
            model.addAttribute("books",bookList);
        }
        logger.writeLog("book read count - "+ bookList.size());
        backlogger.debug("Controller called {}",this.getClass().getName());
        return "readingList";
    }

    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String addToReadingList(
            @PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        repo.save(book);
        spLogger.writeLog("saved");
        return "redirect:/{reader}";
    }

    @RequestMapping(value = "/book/{isbn}/authors")
    public String getAuthors(@PathVariable("isbn") Book book){

        return "authorList";
    }
}
