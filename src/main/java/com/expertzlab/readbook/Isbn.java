package com.expertzlab.readbook;

/**
 * Created by gireeshbabu on 04/01/17.
 */
public class Isbn {

    public Isbn(String text){
        this.isbn = text;
    }
    String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
