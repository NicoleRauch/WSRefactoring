package solutionStep3;

public interface DiscountPolicy {
    Percent getDiscountFor(MonetaryAmount totalAmount);
}
