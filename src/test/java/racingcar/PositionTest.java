package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.car.Position;

class PositionTest {

    private static final int STEP = 1;

    @Test
    void 위치는_step만큼_움직인다() {
        Position position = new Position();

        int prev = 0;
        int next = position.move(STEP);

        assertThat(next).isEqualTo(prev + STEP);
    }

}
