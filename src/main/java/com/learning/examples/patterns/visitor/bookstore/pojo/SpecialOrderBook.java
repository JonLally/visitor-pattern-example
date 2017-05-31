package com.learning.examples.patterns.visitor.bookstore.pojo;

import com.learning.examples.patterns.visitor.bookstore.PurchaseItem;
import com.learning.examples.patterns.visitor.bookstore.PurchaseVisitor;

/**
 * Class representing books specially ordered for customer.
 */
public class SpecialOrderBook extends Book implements PurchaseItem {

    private final double specialOrderMarkup;

    public SpecialOrderBook(String title, String author, String isbnNumber, double price, double specialOrderMarkup) {
        super(title, author, isbnNumber, price);
        this.specialOrderMarkup = specialOrderMarkup;
    }

    public double getSpecialOrderMarkup() {
        return specialOrderMarkup;
    }

    public double accept(PurchaseVisitor visitor) {
        return visitor.visit(this);
    }
}
