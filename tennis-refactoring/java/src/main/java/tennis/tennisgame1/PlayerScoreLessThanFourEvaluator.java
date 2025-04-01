package tennis.tennisgame1;

import java.util.Map;

public final class PlayerScoreLessThanFourEvaluator implements ScoreEvaluator {
    private static final Map<Integer, String> scoreBoardByScore = Map.of(
        0, "Love",
        1, "Fifteen",
        2, "Thirty",
        3, "Forty"
    );

    @Override
    public String evaluateScore(Player player1, Player player2) {
        final int score1 = player1.getScore();
        final int score2 = player2.getScore();

        return score1 != score2 && score1 < 4 && score2 < 4
            ? scoreBoardByScore.get(score1) + "-" + scoreBoardByScore.get(score2)
            : null;
    }
}
