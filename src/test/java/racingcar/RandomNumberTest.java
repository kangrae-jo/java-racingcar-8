package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ApplicationTest.MOVING_FORWARD;
import static racingcar.ApplicationTest.STOP;

import org.junit.jupiter.api.Test;
import racingcar.domain.number.RandomNumber;

class RandomNumberTest {

    @Test
    void 랜덤수가_임계값_이상이면_전진한다() {
        assertRandomNumberInRangeTest(() -> {
                    RandomNumber randomNumber = new RandomNumber();
                    assertThat(randomNumber.canMove(4)).isTrue();
                }, MOVING_FORWARD
        );
    }

    @Test
    void 랜덤수가_임계값_미만이면_전진하지_않는다() {

        assertRandomNumberInRangeTest(() -> {
                    RandomNumber randomNumber = new RandomNumber();
                    assertThat(randomNumber.canMove(4)).isFalse();
                }, STOP
        );
    }

    @Test
    void 랜덤수는_새로고침_할_수_있다() {
        RandomNumber randomNumber = new RandomNumber();

        assertRandomNumberInRangeTest(() -> {
                    randomNumber.refresh();
                    assertThat(randomNumber.canMove(4)).isTrue();
                }, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(() -> {
                    randomNumber.refresh();
                    assertThat(randomNumber.canMove(4)).isFalse();
                }, STOP
        );
    }

}
