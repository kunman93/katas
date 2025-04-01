package tennis.tennisgame1;

public final class PlayerScoreGreaterOrEqualFourEvaluator implements ScoreEvaluator {

    @Override
    public String evaluateScore(Player player1, Player player2) {
        final int score1 = player1.getScore();
        final int score2 = player2.getScore();

        if (score1 != score2 && score1 >= 4 || score2 >= 4) {
            final var leadingPlayer = score1 > score2 ? player1.getName() : player2.getName();
            final var pointDifference = Math.abs(score1 - score2);
            return (pointDifference == 1)
                ? "Advantage " + leadingPlayer
                : "Win for " + leadingPlayer;
        }

        return null;
    }
}
