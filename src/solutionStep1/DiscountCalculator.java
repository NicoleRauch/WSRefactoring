// based on an idea from https://codescracker.com

package solutionStep1;

import java.util.Scanner;

public class DiscountCalculator {
    public static double calcDiscount(double amount, Percent percent) {

        return amount - amount * percent.getPercentage() / 100;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the total amount of your shopping: ");
        double totalAmount = scan.nextFloat();

        System.out.println(calculateTotalPrice(totalAmount));
    }

    public static String calculateTotalPrice(double totalAmount) {
        Percent percentage;

        if (totalAmount <= 80) {
            percentage = new Percent(0);
        } else if (totalAmount > 80 && totalAmount <= 150) {
            percentage = new Percent(10);
        } else if (totalAmount > 150 && totalAmount <= 250) {
            percentage = new Percent(15);
        } else if (totalAmount > 250 && totalAmount <= 500) {
            percentage = new Percent(20);
        } else {
            percentage = new Percent(30);
        }

        double discount = calcDiscount(totalAmount, percentage);

        if (totalAmount <= 80)
            return "You need to pay " + totalAmount;
        else {
            return "Congrats, you've got " + percentage.getPercentage() + "% discount on the total purchase!"
                + "\nYou save " + (totalAmount - discount)
                + "\nNow you only need to pay " + discount;
        }
    }
}
