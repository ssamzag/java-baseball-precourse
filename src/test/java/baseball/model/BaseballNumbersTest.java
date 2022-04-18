package baseball.model;

import baseball.exception.BaseballIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BaseballNumbersTest {

    @Test
    @DisplayName("3개의 숫자 입력하여 PlayerNumbers 생성")
    void createPlayerNumbers() {
        assertThat(BaseballNumbersFactory.create("123").getRound(2))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("andom.pickUniqueNumbersInRange 메서드로 StrikeNumbers 를 생성한다")
    void strikeNumbersCreateTest() {
        BaseballNumbers strikeNumbers =
                BaseballNumbersFactory.create(
                        Random.pickUniqueNumbersInRange(1, 9, 3));
        assertThat(strikeNumbers.getRound(0)).isBetween(1, 9);
        assertThat(strikeNumbers.getRound(1)).isBetween(1, 9);
        assertThat(strikeNumbers.getRound(2)).isBetween(1, 9);
    }

}
