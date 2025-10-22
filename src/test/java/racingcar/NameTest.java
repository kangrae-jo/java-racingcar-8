package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "12345", "kng    ", "    kng"})
    void 자동차_이름은_1자_이상_5자_이하이다(String input) {
        assertThatCode(() -> new Name(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiiii", "woniiiii", "junnnn", " "})
    void 자동차_이름으로_1자_미만_5자_초과는_오류를_발생시킨다(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}