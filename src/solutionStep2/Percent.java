package solutionStep2;

public class Percent {
    private final double percentage;

    public static Percent fromNumeral(double numeralPercentage){
        return new Percent(numeralPercentage);
    }
    public static Percent fromDecimal(double decimalPercentage){
        return new Percent(decimalPercentage * 100);
    }

    private Percent(double percentage) {
        this.percentage = percentage;
    }

    double asNumeral() {
        return percentage;
    }

    double asDecimal() {
        return percentage / 100;
    }
}
