package solutionStep3;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Percent percent = (Percent) o;
        return Double.compare(percent.percentage, percentage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentage);
    }
}
