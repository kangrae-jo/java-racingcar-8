package racingcar.domain.number;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestConstant.MOVING_FORWARD;
import static racingcar.TestConstant.STOP;

import org.junit.jupiter.api.Test;

class RandomNumberTest {

    private final static int THRESHOLD = 4;

    @Test
    void 랜덤수가_임계값_이상이면_전진한다() {
        RandomNumber randomNumber = new RandomNumber();

        assertRandomNumberInRangeTest(() -> {
                    randomNumber.refresh();
                    assertThat(randomNumber.canMove(THRESHOLD)).isTrue();
                }, MOVING_FORWARD
        );
    }

    @Test
    void 랜덤수가_임계값_미만이면_전진하지_않는다() {
        RandomNumber randomNumber = new RandomNumber();

        assertRandomNumberInRangeTest(() -> {
                    randomNumber.refresh();
                    assertThat(randomNumber.canMove(THRESHOLD)).isFalse();
                }, STOP
        );
    }

    @Test
    void 랜덤수는_새로고침_할_수_있다() {
        RandomNumber randomNumber = new RandomNumber();

        assertRandomNumberInRangeTest(() -> {
                    randomNumber.refresh();
                    assertThat(randomNumber.canMove(THRESHOLD)).isTrue();
                }, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(() -> {
                    randomNumber.refresh();
                    assertThat(randomNumber.canMove(THRESHOLD)).isFalse();
                }, STOP
        );
    }

}
