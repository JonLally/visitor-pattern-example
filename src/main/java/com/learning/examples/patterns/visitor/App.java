package com.learning.examples.patterns.visitor;

import com.learning.examples.patterns.visitor.bookstore.PurchaseItem;
import com.learning.examples.patterns.visitor.bookstore.PurchaseVisitor;
import com.learning.examples.patterns.visitor.bookstore.PurchaseVisitorImpl;
import com.learning.examples.patterns.visitor.bookstore.pojo.DiscountedBook;
import com.learning.examples.patterns.visitor.bookstore.pojo.SpecialOrderBook;
import com.learning.examples.patterns.visitor.bookstore.pojo.ThreeForTwoOfferBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor pattern main.
 *
 */
public class App {
    public static void main(String[] args) {
        List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>();
        purchaseItems.add(new ThreeForTwoOfferBook("Book 1", "Timmy", "12-eed-786", 10.0));
        purchaseItems.add(new ThreeForTwoOfferBook("Book 2", "Timmy", "12-eed-786", 10.0));
        purchaseItems.add(new ThreeForTwoOfferBook("Book 3", "Timmy", "12-eed-786", 10.0));
        purchaseItems.add(new SpecialOrderBook("Book 4", "Timmy", "12-eed-786", 10.0, 1.0));
        purchaseItems.add(new DiscountedBook("Book 1", "Timmy", "12-eed-786", 10.0, .1));
        calculatePrice(purchaseItems);
    }

    private static void calculatePrice(List<PurchaseItem> items) {
        PurchaseVisitor purchaseVisitor = new PurchaseVisitorImpl();
        double total = 0;
        for (final PurchaseItem purchaseItem : items) {
            total += purchaseItem.accept(purchaseVisitor);
        }
        System.out.println("Total price is " + total);
    }
}
