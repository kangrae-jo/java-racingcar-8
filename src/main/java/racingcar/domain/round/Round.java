package racingcar.domain.round;

public class Round {

    private final int totalRound;
    private int currentRound;

    public Round(int totalRound) {
        this.totalRound = totalRound;
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

}
