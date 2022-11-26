package solutionStep3;

public class GenerousDiscountPolicy implements DiscountPolicy {

    public Percent getDiscountFor(MonetaryAmount totalAmount) {

        if (totalAmount.amount() <= 80) {
            return Percent.fromNumeral(0);
        }
        if (totalAmount.amount() <= 150) {
            return Percent.fromNumeral(10);
        }
        if (totalAmount.amount() <= 250) {
            return Percent.fromNumeral(15);
        }
        if (totalAmount.amount() <= 500) {
            return Percent.fromNumeral(20);
        }
        return Percent.fromNumeral(30);
    }
}
