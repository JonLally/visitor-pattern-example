package com.learning.examples.patterns.visitor.bookstore

import com.learning.examples.patterns.visitor.bookstore.pojo.DiscountedBook
import com.learning.examples.patterns.visitor.bookstore.pojo.SpecialOrderBook
import com.learning.examples.patterns.visitor.bookstore.pojo.ThreeForTwoOfferBook
import spock.lang.Specification

/**
 * Tests for the visitor pattern.
 */
class PurchaseVisitorSpec extends Specification {

    PurchaseVisitor objUnderTest = new PurchaseVisitorImpl()

    def 'purchase one discounted book, applies discount and returns correct price'() {
        given: 'a discounted book with price €10 and discount rate 10%'
            def discountedBook = new DiscountedBook("Book 1", "Timmy", "12-ecd-786", 10.0, 0.1)

        when: 'the total price of the purchase is calculated'
            def total = calculatePrice([discountedBook])

        then: 'the price will be €20'
            total == 9
    }

    def 'purchase one special order book, adds markup for special order and returns correct price'() {
        given: 'a special order book with price of €15 and markup of €2'
            def specialOrderBook = new SpecialOrderBook("Book 2", "Timmy", "12-ead-786", 15.0, 2.0)

        when: 'the total price of the purchase is calculated'
            def total = calculatePrice([specialOrderBook])

        then: 'the price will be €20'
            total == 17
    }

    def 'purchase 3 for 2 offer book, only subtracts every third book price'() {
        given: '3 x 3 for 2 offer books with price €10'
            def threeForTwoBook1 = new ThreeForTwoOfferBook("Book 3", "Timmy", "12-eed-786", 10.0)
            def threeForTwoBook2 = new ThreeForTwoOfferBook("Book 4", "Timmy", "12-eed-787", 10.0)
            def threeForTwoBook3 = new ThreeForTwoOfferBook("Book 5", "Timmy", "12-eed-788", 10.0)

        when: 'the total price of the purchase is calculated'
            def total = calculatePrice([threeForTwoBook1, threeForTwoBook2, threeForTwoBook3])

        then: 'the price will be €20'
            total == 20
    }

    private double calculatePrice(List<PurchaseItem> items) {
        double total = 0
        items.each { purchaseItem ->
            total += purchaseItem.accept(objUnderTest)
        }
        return total
    }

}
