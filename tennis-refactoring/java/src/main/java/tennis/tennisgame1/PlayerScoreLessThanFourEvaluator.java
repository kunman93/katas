package tennis.tennisgame1;

import static tennis.tennisgame1.Constants.SCOREBOARD_BY_SCORE;

public final class PlayerScoreLessThanFourEvaluator implements ScoreEvaluator {

    @Override
    public String evaluateScore(Player player1, Player player2) {
        final int score1 = player1.getScore();
        final int score2 = player2.getScore();

        return score1 != score2 && score1 < 4 && score2 < 4
            ? SCOREBOARD_BY_SCORE.get(score1) + "-" + SCOREBOARD_BY_SCORE.get(score2)
            : null;
    }
}
