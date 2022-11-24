package start;

import org.junit.Assert;
import org.junit.Test;

public class DiscountCalculatorTest {

    @Test
    public void calcDiscount_0Percent() {
        Assert.assertEquals(100.0, DiscountCalculator.calcDiscount(100.0, 0.0), 0.0001);
    }

    @Test
    public void calcDiscount_2Percent() {
        Assert.assertEquals(98.0, DiscountCalculator.calcDiscount(100.0, 2.0), 0.0001);
    }

    @Test
    public void calculateTotalPrice_0Euro() {
        Assert.assertEquals("You need to pay 0.0", DiscountCalculator.calculateTotalPrice(0.0));
    }

    @Test
    public void calculateTotalPrice_77Euro() {
        Assert.assertEquals("You need to pay 77.0", DiscountCalculator.calculateTotalPrice(77.0));
    }

    @Test
    public void calculateTotalPrice_100Euro() {
        Assert.assertEquals("Congrats, you've got 10.0% discount on the total purchase!\n" +
                "You save 10.0\n" +
                "Now you only need to pay 90.0", DiscountCalculator.calculateTotalPrice(100.0));
    }

    @Test
    public void calculateTotalPrice_200Euro() {
        Assert.assertEquals("Congrats, you've got 15.0% discount on the total purchase!\n" +
                "You save 30.0\n" +
                "Now you only need to pay 170.0", DiscountCalculator.calculateTotalPrice(200.0));
    }

    @Test
    public void calculateTotalPrice_400Euro() {
        Assert.assertEquals("Congrats, you've got 20.0% discount on the total purchase!\n" +
                "You save 80.0\n" +
                "Now you only need to pay 320.0", DiscountCalculator.calculateTotalPrice(400.0));
    }

    @Test
    public void calculateTotalPrice_600Euro() {
        Assert.assertEquals("Congrats, you've got 30.0% discount on the total purchase!\n" +
                "You save 180.0\n" +
                "Now you only need to pay 420.0", DiscountCalculator.calculateTotalPrice(600.0));
    }
}
