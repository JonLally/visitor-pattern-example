package com.learning.examples.patterns.visitor.bookstore.pojo;

import com.learning.examples.patterns.visitor.bookstore.PurchaseItem;
import com.learning.examples.patterns.visitor.bookstore.PurchaseVisitor;

import java.util.Calendar;

/**
 * class to handle 3 for 2 offer books.
 */
public class ThreeForTwoOfferBook extends Book implements PurchaseItem {

    public ThreeForTwoOfferBook(String title, String author, String isbnNumber, double price) {
        super(title, author, isbnNumber, price);
    }

    public double accept(PurchaseVisitor visitor) {
        return visitor.visit(this);
    }
}
