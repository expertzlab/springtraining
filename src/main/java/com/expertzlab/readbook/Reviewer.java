package com.expertzlab.readbook;

import javax.persistence.*;

/**
 * Created by gireeshbabu on 10/01/17.
 */

@Entity
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    /*
    @JoinColumn(name = "id")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    */
}
