// based on an idea from https://codescracker.com

package solutionStep2;

import java.util.Scanner;

public class DiscountCalculator {
    public static DiscountedAmount calcDiscount(MonetaryAmount monetaryAmount, Percent percent) {

        return new DiscountedAmount(monetaryAmount.amount() - monetaryAmount.amount() * percent.asDecimal());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the total amount of your shopping: ");
        double totalAmount = scan.nextFloat();

        System.out.println(calculateTotalPrice(new MonetaryAmount(totalAmount)));
    }

    public static String calculateTotalPrice(MonetaryAmount totalAmount) {
        Percent percentage;

        if (totalAmount.amount() <= 80) {
            percentage = new Percent(0);
        } else if (totalAmount.amount() > 80 && totalAmount.amount() <= 150) {
            percentage = new Percent(10);
        } else if (totalAmount.amount() > 150 && totalAmount.amount() <= 250) {
            percentage = new Percent(15);
        } else if (totalAmount.amount() > 250 && totalAmount.amount() <= 500) {
            percentage = new Percent(20);
        } else {
            percentage = new Percent(30);
        }

        DiscountedAmount discount = calcDiscount(totalAmount, percentage);

        if (totalAmount.amount() <= 80)
            return "You need to pay " + totalAmount.amount(); // or totalAmount.toString()
        else {
            return "Congrats, you've got " + percentage.asNumeral() + "% discount on the total purchase!"
                + "\nYou save " + (totalAmount.amount() - discount.amount())
                + "\nNow you only need to pay " + discount.amount();
        }
    }
}
