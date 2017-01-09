package com.expertzlab.readbook;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gireeshbabu on 04/01/17.
 */
public interface BookRepo extends JpaRepository<Book, String> {
    public Book findBookByIsbn(String isbn);
}
