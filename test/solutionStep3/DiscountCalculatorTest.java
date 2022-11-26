package solutionStep3;

import org.junit.Assert;
import org.junit.Test;
import solutionStep3.DiscountCalculator;
import solutionStep3.DiscountPolicy;
import solutionStep3.GenerousDiscountPolicy;
import solutionStep3.MonetaryAmount;
import solutionStep3.Percent;

public class DiscountCalculatorTest {

    @Test
    public void calcDiscount_0Percent() {
        Assert.assertEquals(100.0, new MonetaryAmount(100.0).applyDiscount(Percent.fromNumeral(0.0)).amount(), 0.0001);
    }

    @Test
    public void calcDiscount_2Percent() {
        Assert.assertEquals(98.0, new MonetaryAmount(100.0).applyDiscount(Percent.fromNumeral(2.0)).amount(), 0.0001);
    }

    ///////////////////////////////////////////////////////////////////////////
    
    @Test
    public void calculateTotalPrice_NoDiscount() {
        Assert.assertEquals("You need to pay 77.0",
                DiscountCalculator.calculateTotalPrice(new MonetaryAmount(77.0), new DiscountPolicy() {
                    @Override
                    public Percent getDiscountFor(MonetaryAmount totalAmount) {
                        return Percent.fromNumeral(0);
                    }
                }));
    }

    @Test
    public void calculateTotalPrice_Discount() {
        Assert.assertEquals("Congrats, you've got 10.0% discount on the total purchase!\n" +
                        "You save 10.0\n" +
                        "Now you only need to pay 90.0",
                DiscountCalculator.calculateTotalPrice(new MonetaryAmount(100.0), new DiscountPolicy() {
                    @Override
                    public Percent getDiscountFor(MonetaryAmount totalAmount) {
                        return Percent.fromNumeral(10);
                    }
                }));
    }

    ///////////////////////////////////////////////////////////////////////////
    
    @Test
    public void getGenerousDiscountFor_0Euro() {
        Assert.assertEquals(Percent.fromNumeral(0), new GenerousDiscountPolicy().getDiscountFor(new MonetaryAmount(0)));
    }

    @Test
    public void getGenerousDiscountFor_77Euro() {
        Assert.assertEquals(Percent.fromNumeral(0), new GenerousDiscountPolicy().getDiscountFor(new MonetaryAmount(77)));
    }

    @Test
    public void getGenerousDiscountFor_100Euro() {
        Assert.assertEquals(Percent.fromNumeral(10), new GenerousDiscountPolicy().getDiscountFor(new MonetaryAmount(100)));
    }

    @Test
    public void getGenerousDiscountFor_200Euro() {
        Assert.assertEquals(Percent.fromNumeral(15), new GenerousDiscountPolicy().getDiscountFor(new MonetaryAmount(200)));
    }

    @Test
    public void getGenerousDiscountFor_400Euro() {
        Assert.assertEquals(Percent.fromNumeral(20), new GenerousDiscountPolicy().getDiscountFor(new MonetaryAmount(400)));
    }

    @Test
    public void getGenerousDiscountFor_600Euro() {
        Assert.assertEquals(Percent.fromNumeral(30), new GenerousDiscountPolicy().getDiscountFor(new MonetaryAmount(600)));
    }
}
