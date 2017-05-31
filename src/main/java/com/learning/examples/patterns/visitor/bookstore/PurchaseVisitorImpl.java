package com.learning.examples.patterns.visitor.bookstore;

import com.learning.examples.patterns.visitor.bookstore.pojo.Book;
import com.learning.examples.patterns.visitor.bookstore.pojo.DiscountedBook;
import com.learning.examples.patterns.visitor.bookstore.pojo.SpecialOrderBook;
import com.learning.examples.patterns.visitor.bookstore.pojo.ThreeForTwoOfferBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Implemention of the Visitor Interface.
 */
public class PurchaseVisitorImpl implements PurchaseVisitor {

    private List<Book> booksToPurchase;

    public PurchaseVisitorImpl() {
        booksToPurchase = new ArrayList<Book>();
    }

    public double visit(DiscountedBook discountedBook) {
        booksToPurchase.add(discountedBook);
        return discountedBook.getPrice() - (discountedBook.getPrice() * discountedBook.getDiscountToApply());
    }

    public double visit(SpecialOrderBook specialOrderBook) {
        booksToPurchase.add(specialOrderBook);
        return specialOrderBook.getPrice() + specialOrderBook.getSpecialOrderMarkup();
    }

    public double visit(ThreeForTwoOfferBook threeForTwoOfferBook) {
        booksToPurchase.add(threeForTwoOfferBook);
        int threeForTwoBooksPurchasedSoFar = 0;
        for (final Book book : booksToPurchase) {
            if (book instanceof ThreeForTwoOfferBook) {
                if (++threeForTwoBooksPurchasedSoFar % 3 == 0) {
                    return 0;
                }
            }
        }
        return threeForTwoOfferBook.getPrice();
    }
}
