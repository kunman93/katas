package tennis.tennisgame1;

public final class PlayerScoreGreaterOrEqualFourEvaluator implements ScoreEvaluator {

    @Override
    public String evaluateScore(Player player1, Player player2) {
        final int score1 = player1.getScore();
        final int score2 = player2.getScore();

        if (score1 != score2 && score1 >= 4 || score2 >= 4) {
            final int scoreDifference = Math.abs(score1 - score2);
            final boolean isPlayer1Leading = score1 > score2;

            final String player1Name = player1.getName();
            final String player2Name = player2.getName();
            if (scoreDifference == 1) {
                return isPlayer1Leading
                    ? "Advantage " + player1Name
                    : "Advantage " + player2Name;
            }

            return isPlayer1Leading
                ? "Win for " + player1Name
                : "Win for " + player2Name;
        }

        return null;
    }
}
