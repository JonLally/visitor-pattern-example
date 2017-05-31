package com.learning.examples.patterns.visitor.bookstore;

import com.learning.examples.patterns.visitor.bookstore.pojo.DiscountedBook;
import com.learning.examples.patterns.visitor.bookstore.pojo.SpecialOrderBook;
import com.learning.examples.patterns.visitor.bookstore.pojo.ThreeForTwoOfferBook;

/**
 * Visitor Interface.
 */
public interface PurchaseVisitor {

    double visit(DiscountedBook discountedBook);

    double visit(SpecialOrderBook specialOrderBook);

    double visit(ThreeForTwoOfferBook threeForTwoOfferBook);

}
