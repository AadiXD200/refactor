package theater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Data transfer object for statement generation.
 */
public class StatementData {

    private final Invoice invoice;
    private final Map<String, Play> plays;
    private final List<PerformanceData> performances;

    public StatementData(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;
        this.plays = plays;
        this.performances = new ArrayList<>();
        for (Performance performance : invoice.getPerformances()) {
            performances.add(new PerformanceData(
                    AbstractPerformanceCalculator.createPerformanceCalculator(performance, getPlay(performance))));
        }
    }

    public String getCustomer() {
        return invoice.getCustomer();
    }

    public List<PerformanceData> getPerformances() {
        return performances;
    }

    public int getTotalAmount() {
        int result = 0;
        for (PerformanceData performanceData : performances) {
            result += performanceData.amountFor();
        }
        return result;
    }

    public int getTotalVolumeCredits() {
        int result = 0;
        for (PerformanceData performanceData : performances) {
            result += performanceData.volumeCredits();
        }
        return result;
    }

    private Play getPlay(Performance performance) {
        return plays.get(performance.getPlayID());
    }
}
