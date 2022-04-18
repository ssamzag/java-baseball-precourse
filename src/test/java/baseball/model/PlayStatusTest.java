package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayStatusTest {

    @ParameterizedTest
    @DisplayName("String 인자로 PlayStatus enum 를 반환한다")
    @CsvSource(value = {"1,RESTART", "2,EXIT", "3,ETC"})
    void fromValue(String value, PlayStatus expected) {
        assertThat(PlayStatus.fromValue(value)).isEqualTo(expected);
    }


}
