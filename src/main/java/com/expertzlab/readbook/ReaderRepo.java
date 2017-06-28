package com.expertzlab.readbook;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gireeshbabu on 29/12/16.
 */
public interface ReaderRepo extends JpaRepository<Reader, String> {

    Reader findOne(String username);
    Reader save(Reader reader);
}
