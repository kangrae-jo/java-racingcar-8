package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.round.Round;

class RoundTest {

    private static final String TOTAL_ROUND = "10";

    @Test
    void 시도할_횟수_만큼만_라운드를_반복한다() {
        Round round = new Round(TOTAL_ROUND);

        int times = 0;
        while (round.canNext()) {
            round.proceed();
            times++;
        }

        assertThat(times).isEqualTo(Integer.parseInt(TOTAL_ROUND));
    }

}
