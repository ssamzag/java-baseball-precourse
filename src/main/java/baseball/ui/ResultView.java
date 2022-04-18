package baseball.ui;

import baseball.model.BaseballRecord;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String OUT_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_EXIT = "게임을 종료합니다.";
    private static final String DELIMITER = " ";

    public static void printGameRecord(BaseballRecord baseballRecord) {
        System.out.println(getJudgementString(baseballRecord));
    }

    private static String getJudgementString(BaseballRecord baseballRecord) {
        if (baseballRecord.hasOut()) {
            return OUT_MESSAGE;
        }

        List<String> judgementList = new ArrayList<>();
        if (baseballRecord.hasBall()) {
             judgementList.add(baseballRecord.getBallCount() + BALL_MESSAGE);
        }
        if (baseballRecord.hasStrike()) {
            judgementList.add(baseballRecord.getStrikeCount() + STRIKE_MESSAGE);
        }

        return String.join(DELIMITER, judgementList);
    }

    public static void printWinMessage() {
        System.out.println(WIN_MESSAGE);
    }

    public static void printExitMessage() {
        System.out.print(GAME_EXIT);
    }

}
