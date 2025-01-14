package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("야구게임 결과기록 테스트")
class BaseballRecordTest {
    @Test
    @DisplayName("2 스트라이크를 반환한다")
    void strikeTest() {
        BaseballNumbers strikeNumbers = new BaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballNumbers playerNumbers = new BaseballNumbers(Arrays.asList(1, 2, 5));
        BaseballRecord baseballRecord = new BaseballRecord();
        baseballRecord.updateRecordResult(strikeNumbers, playerNumbers);
        assertThat(baseballRecord.getStrikeCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("1스트라이크 1볼을 반환한다")
    void strikeAndBallTest() {
        BaseballNumbers strikeNumbers = new BaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballNumbers playerNumbers = new BaseballNumbers(Arrays.asList(1, 3, 5));
        BaseballRecord baseballRecord = new BaseballRecord();
        baseballRecord.updateRecordResult(strikeNumbers, playerNumbers);
        assertThat(baseballRecord.getStrikeCount()).isEqualTo(1);
        assertThat(baseballRecord.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("낫씽을 조회한다")
    void outTest() {
        BaseballNumbers strikeNumbers = new BaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballNumbers playerNumbers = new BaseballNumbers(Arrays.asList(4, 5, 6));
        BaseballRecord baseballRecord = new BaseballRecord();
        baseballRecord.updateRecordResult(strikeNumbers, playerNumbers);
        assertThat(baseballRecord.hasOut()).isTrue();
    }

    @Test
    @DisplayName("3 스트라이크와 승리여부를 조회한다")
    void strikeAndWin() {
        BaseballNumbers strikeNumbers = new BaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballNumbers playerNumbers = new BaseballNumbers(Arrays.asList(1, 2, 3));
        BaseballRecord baseballRecord = new BaseballRecord();
        baseballRecord.updateRecordResult(strikeNumbers, playerNumbers);
        assertThat(baseballRecord.isWin()).isTrue();
        assertThat(baseballRecord.getStrikeCount()).isEqualTo(3);
    }
}
