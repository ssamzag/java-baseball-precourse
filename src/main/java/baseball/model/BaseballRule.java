package baseball.model;

public class BaseballRule {
    public static JudgementType judgeStrikeOrBall(int round, BaseballNumbers strikeNumbers, BaseballNumbers playerNumbers) {
        if (strikeNumbers.getRound(round) == playerNumbers.getRound(round)) {
            return JudgementType.STRIKE;
        }
        if (strikeNumbers.contains(playerNumbers.getRound(round))) {
            return JudgementType.BALL;
        }
        return JudgementType.NOTHING;
    }

}
