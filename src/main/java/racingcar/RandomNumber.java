package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private final static int START_INCLUSIVE = 0;
    private final static int END_INCLUSIVE = 9;

    private int number;

    public RandomNumber() {
        this.refresh();
    }

    public void refresh() {
        this.number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public boolean canMove(int threshold) {
        return this.number >= threshold;
    }

}
