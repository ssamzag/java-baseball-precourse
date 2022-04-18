package baseball.model;

import baseball.exception.BaseballIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerNumbersTest {

    @Test
    @DisplayName("3개의 숫자 입력하여 PlayerNumbers 생성")
    void createPlayerNumbers() {
        assertThat(new PlayerNumbers("123").getRound(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력한 숫자가 포함되어 있는지 조회한다")
    void numberContains() {
        StrikeNumbers strikeNumbers = new StrikeNumbers(Arrays.asList(1, 2, 3));
        assertThat(strikeNumbers.contains(1)).isTrue();
        assertThat(strikeNumbers.contains(2)).isTrue();
        assertThat(strikeNumbers.contains(3)).isTrue();
    }

    @Test
    @DisplayName("4개의 숫자 입력시 예외가 발생한다")
    void overNumbersException() {
        assertThatExceptionOfType(BaseballIllegalArgumentException.class).isThrownBy(() -> {
            new PlayerNumbers("1234");
        });
    }

    @Test
    @DisplayName("잘못된 문자 입력시 예외가 발생한다")
    void wrongStringException() {
        assertThatExceptionOfType(BaseballIllegalArgumentException.class).isThrownBy(() -> {
            new PlayerNumbers("12a");
        });
    }

    @Test
    @DisplayName("중복숫자 입력시 예외가 발생한다")
    void duplicatedNumbersException() {
        assertThatExceptionOfType(BaseballIllegalArgumentException.class).isThrownBy(() -> {
            new PlayerNumbers("122");
        });
    }

}
