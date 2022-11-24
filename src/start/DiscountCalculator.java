// based on an idea from https://codescracker.com

package start;

import java.util.Scanner;

public class DiscountCalculator {
    public static double calcDiscount(double amount,
                                      double percentage) {

        return amount - amount * percentage / 100;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the total amount of your shopping: ");
        double totalAmount = scan.nextFloat();

        System.out.println(calculateTotalPrice(totalAmount));
    }

    public static String calculateTotalPrice(double totalAmount) {
        double percentage;

        if (totalAmount <= 80) {
            percentage = 0;
        } else if (totalAmount > 80 && totalAmount <= 150) {
            percentage = 10;
        } else if (totalAmount > 150 && totalAmount <= 250) {
            percentage = 15;
        } else if (totalAmount > 250 && totalAmount <= 500) {
            percentage = 20;
        } else {
            percentage = 30;
        }

        double discount = calcDiscount(totalAmount, percentage);

        if (totalAmount <= 80)
            return "You need to pay " + totalAmount;
        else {
            return "Congrats, you've got " + percentage + "% discount on the total purchase!"
                + "\nYou save " + (totalAmount - discount)
                + "\nNow you only need to pay " + discount;
        }
    }
}
