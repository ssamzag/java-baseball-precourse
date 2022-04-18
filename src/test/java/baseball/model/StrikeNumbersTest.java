package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeNumbersTest {

    @Test
    @DisplayName("andom.pickUniqueNumbersInRange 메서드로 StrikeNumbers 를 생성한다")
    void strikeNumbersCreateTest() {
        StrikeNumbers strikeNumbers = new StrikeNumbers(Random.pickUniqueNumbersInRange(1, 9, 3));
        assertThat(strikeNumbers.getRound(0)).isBetween(1, 9);
        assertThat(strikeNumbers.getRound(1)).isBetween(1, 9);
        assertThat(strikeNumbers.getRound(2)).isBetween(1, 9);
    }

    @Test
    @DisplayName("입력한 숫자가 포함되어 있는지 조회한다")
    void numberContains() {
        StrikeNumbers strikeNumbers = new StrikeNumbers(Arrays.asList(1, 2, 3));
        assertThat(strikeNumbers.contains(1)).isTrue();
        assertThat(strikeNumbers.contains(2)).isTrue();
        assertThat(strikeNumbers.contains(3)).isTrue();
    }
}
