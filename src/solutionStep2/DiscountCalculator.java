// based on an idea from https://codescracker.com

package solutionStep2;

import java.util.Scanner;

public class DiscountCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the total amount of your shopping: ");
        double totalAmount = scan.nextFloat();

        System.out.println(calculateTotalPrice(new MonetaryAmount(totalAmount)));
    }

    public static String calculateTotalPrice(MonetaryAmount totalAmount) {
        Percent percentage;

        if (totalAmount.amount() <= 80) {
            percentage = Percent.fromNumeral(0);
        } else if (totalAmount.amount() > 80 && totalAmount.amount() <= 150) {
            percentage = Percent.fromNumeral(10);
        } else if (totalAmount.amount() > 150 && totalAmount.amount() <= 250) {
            percentage = Percent.fromNumeral(15);
        } else if (totalAmount.amount() > 250 && totalAmount.amount() <= 500) {
            percentage = Percent.fromNumeral(20);
        } else {
            percentage = Percent.fromNumeral(30);
        }

        DiscountedAmount discount = totalAmount.applyDiscount(percentage);

        if (totalAmount.amount() <= 80)
            return "You need to pay " + totalAmount.amount(); // or totalAmount.toString()
        else {
            return "Congrats, you've got " + percentage.asNumeral() + "% discount on the total purchase!"
                + "\nYou save " + (totalAmount.amount() - discount.amount())
                + "\nNow you only need to pay " + discount.amount();
        }
    }
}
