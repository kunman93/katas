package tennis.tennisgame1;

import static tennis.tennisgame1.Constants.SCOREBOARD_BY_SCORE;

public final class PlayerScoresAreEqualEvaluator implements ScoreEvaluator {

    @Override
    public String evaluateScore(Player player1, Player player2) {
        final int score1 = player1.getScore();
        final int score2 = player2.getScore();

        if (score1 == score2) {
            return switch (score1) {
                case 0, 1, 2 -> SCOREBOARD_BY_SCORE.get(score1) + "-All";
                default -> "Deuce";
            };
        }

        return null;
    }
}
