package com.learning.examples.patterns.visitor.bookstore.pojo;

import java.util.Comparator;

/**
 * Base class for Books.
 */
public abstract class Book {

    private final String title;
    private final String author;
    private final String isbnNumber;
    private final double price;

    public Book(String title, String author, String isbnNumber, double price) {
        this.title = title;
        this.author = author;
        this.isbnNumber = isbnNumber;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public double getPrice() {
        return price;
    }
}
