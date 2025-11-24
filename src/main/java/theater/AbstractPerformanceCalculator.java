package theater;

/**
 * Base calculator for performance charges and credits.
 */
public abstract class AbstractPerformanceCalculator {

    private final Performance performance;
    private final Play play;

    protected AbstractPerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Play getPlay() {
        return play;
    }

    public abstract int amountFor();

    public int volumeCredits() {
        return Math.max(performance.getAudience() - Constants.BASE_VOLUME_CREDIT_THRESHOLD, 0);
    }

    public static AbstractPerformanceCalculator createPerformanceCalculator(Performance performance, Play play) {
        switch (play.getType()) {
            case "tragedy":
                return new TragedyPerformanceCalculator(performance, play);
            case "comedy":
                return new ComedyPerformanceCalculator(performance, play);
            case "history":
                return new HistoryPerformanceCalculator(performance, play);
            case "pastoral":
                return new PastoralPerformanceCalculator(performance, play);
            default:
                throw new RuntimeException(String.format("unknown type: %s", play.getType()));
        }
    }
}
