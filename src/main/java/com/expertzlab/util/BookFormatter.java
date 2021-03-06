package com.expertzlab.util;

import com.expertzlab.readbook.Book;
import com.expertzlab.readbook.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by gireeshbabu on 10/01/17.
 */
public class BookFormatter implements Formatter<Book> {

    private BookRepo repo;

    public BookFormatter(BookRepo repo){
        this.repo = repo;
    }

    @Override
    public Book parse(String bookId, Locale locale) throws ParseException {
        Book book = repo.findBookByIsbn(bookId);
        return book != null ? book: repo.findOne(bookId);
    }

    @Override
    public String print(Book book, Locale locale) {
        return book.getIsbn();
    }
}
