package com.expertzlab.readbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gireeshbabu on 04/01/17.
 */

@Repository
public interface BookRepo extends JpaRepository<Book, String> {
    public Book findBookByIsbn(String isbn);
}
