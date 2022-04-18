package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseballRuleTest {

    @ParameterizedTest
    @DisplayName("BaseballRule.judgeStrikeOrBall 메소드를 이용해 판정을 확인한다")
    @MethodSource("parametersProvider")
    void judgeStrikeOrBallTest (
            JudgementType expectType,
            int round,
            StrikeNumbers strikeNumbers,
            PlayerNumbers playerNumbers) {
        JudgementType judgementType = BaseballRule.judgeStrikeOrBall(round, strikeNumbers, playerNumbers);
        assertThat(judgementType).isEqualTo(expectType);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments(
                        JudgementType.STRIKE,
                        1,
                        new StrikeNumbers(Arrays.asList(1, 2, 4)),
                        new PlayerNumbers(Arrays.asList(1, 2, 4))),
                arguments(
                        JudgementType.BALL,
                        1,
                        new StrikeNumbers(Arrays.asList(3, 1, 4)),
                        new PlayerNumbers(Arrays.asList(1, 3, 4))),
                arguments(
                        JudgementType.NOTHING,
                        1,
                        new StrikeNumbers(Arrays.asList(5, 2, 4)),
                        new PlayerNumbers(Arrays.asList(1, 3, 5)))
        );
    }

}
