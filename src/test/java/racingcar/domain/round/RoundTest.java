package racingcar.domain.round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"0", "1001"})
    void 라운드는_1이상_1000이하로_제한한다(String round) {
        assertThatThrownBy(() -> new Round(round))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
