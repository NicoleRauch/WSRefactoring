package solutionStep2;

public record MonetaryAmount(double amount) {
    public DiscountedAmount applyDiscount(Percent percent) {

        return new DiscountedAmount(amount - amount * percent.asDecimal());
    }
}
