// based on an idea from https://codescracker.com

package solutionStep3;

import java.util.Scanner;

public class DiscountCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the total amount of your shopping: ");
        double totalAmount = scan.nextFloat();

        System.out.println(calculateTotalPrice(new MonetaryAmount(totalAmount), new GenerousDiscountPolicy()));
    }

    public static String calculateTotalPrice(MonetaryAmount totalAmount, DiscountPolicy discountPolicy) {
        Percent percentage = discountPolicy.getDiscountFor(totalAmount);

        DiscountedAmount discount = totalAmount.applyDiscount(percentage);

        if (percentage.asNumeral() == 0)
            return "You need to pay " + totalAmount.amount(); // or totalAmount.toString()
        else {
            return "Congrats, you've got " + percentage.asNumeral() + "% discount on the total purchase!"
                + "\nYou save " + (totalAmount.amount() - discount.amount())
                + "\nNow you only need to pay " + discount.amount();
        }
    }
}
