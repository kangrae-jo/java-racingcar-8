package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {

    private final static int START_INCLUSIVE = 0;
    private final static int END_INCLUSIVE = 9;

    private int number;

    public Dice() {
        this.number = 0;
    }

    public void reroll() {
        this.number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public boolean canMove(int threshold) {
        return this.number >= threshold;
    }

}
