package baseball.model;

public class BaseballRecord {
    private static final int ROUND_COUNT = 3;

    private int strikeCount;
    private int ballCount;

    public void updateRecordResult(BaseballNumbers strikeNumbers, BaseballNumbers playerNumbers) {
        clearRecords();

        for (int round = 0; round < ROUND_COUNT; round++) {
            JudgementType judgementType = BaseballRule.judgeStrikeOrBall(round, strikeNumbers, playerNumbers);
            recordResultCounting(judgementType);
        }
    }

    private void clearRecords() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    private void recordResultCounting(JudgementType judgementType) {
        if (judgementType == JudgementType.STRIKE) {
            this.strikeCount++;
            return;
        }
        if (judgementType == JudgementType.BALL) {
            this.ballCount++;
        }
    }

    public boolean hasOut() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean hasStrike() {
        return strikeCount > 0;
    }

    public boolean hasBall() {
        return ballCount > 0;
    }

    public boolean isWin() {
        return strikeCount == ROUND_COUNT;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
