package com.learning.examples.patterns.visitor.bookstore.pojo;

import com.learning.examples.patterns.visitor.bookstore.PurchaseItem;
import com.learning.examples.patterns.visitor.bookstore.PurchaseVisitor;

/**
 * Class representing a discounted book
 */
public class DiscountedBook extends Book implements PurchaseItem {

    private final double discountToApply;

    public DiscountedBook(String title, String author, String isbnNumber, double price, double discountToApply) {
        super(title, author, isbnNumber, price);
        this.discountToApply = discountToApply;
    }

    public double getDiscountToApply() {
        return discountToApply;
    }

    public double accept(PurchaseVisitor visitor) {
        return visitor.visit(this);
    }
}
