package solutionStep2;

public class Percent {
    private final double percentage;

    public Percent(double percentage) {
        this.percentage = percentage;
    }

    double asNumeral() {
        return percentage;
    }

    double asDecimal() {
        return percentage / 100;
    }
}
