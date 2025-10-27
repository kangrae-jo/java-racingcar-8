package racingcar.domain.round;

public class Round {

    private final static int MIN_ROUND = 1;
    private final static int MAX_ROUND = 1000;

    private final int totalRound;
    private int currentRound;

    public Round(String totalRound) {
        validateTotalRound(totalRound);
        this.totalRound = Integer.parseInt(totalRound);
        this.currentRound = 0;
    }

    public boolean canNext() {
        return totalRound > currentRound;
    }

    public int proceed() {
        if (!canNext()) {
            throw new IllegalArgumentException("[ERROR] 진행할 라운드가 없습니다.");
        }
        return currentRound += 1;
    }

    private void validateTotalRound(String totalRound) {
        try {
            int round = Integer.parseInt(totalRound);
            if (round < MIN_ROUND || MAX_ROUND < round) {
                throw new IllegalArgumentException(
                        String.format("[ERROR] 라운드는 %d 이상 %d 이하만 가능합니다.", MIN_ROUND, MAX_ROUND));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 라운드는 숫자만 입력 가능합니다.");
        }
    }

}
