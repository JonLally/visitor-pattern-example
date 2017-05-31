package com.learning.examples.patterns.visitor.bookstore;

/**
 * Interface to allow books to be accepted by the correct visit method.
 */
public interface PurchaseItem {

    double accept(PurchaseVisitor visitor);

}
