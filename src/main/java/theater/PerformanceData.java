package theater;

/**
 * Holds calculated performance data for statements.
 */
public class PerformanceData {

    private final AbstractPerformanceCalculator calculator;

    public PerformanceData(AbstractPerformanceCalculator calculator) {
        this.calculator = calculator;
    }

    public int getAudience() {
        return calculator.getPerformance().getAudience();
    }

    public String getName() {
        return calculator.getPlay().getName();
    }

    public String getType() {
        return calculator.getPlay().getType();
    }

    public Performance getPerformance() {
        return calculator.getPerformance();
    }

    public int amountFor() {
        return calculator.amountFor();
    }

    public int volumeCredits() {
        return calculator.volumeCredits();
    }
}
