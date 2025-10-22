package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi  ,woni  ,jun,kng"})
    void 자동차들의_이름은_쉼표로_구분된다(String names) {
        assertThatCode(() -> new Cars(names))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiii,woni,jun", "pobiii,,jun"})
    void 자동차_이름은_1자_이상_5자_이내이다(String names) {
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

}