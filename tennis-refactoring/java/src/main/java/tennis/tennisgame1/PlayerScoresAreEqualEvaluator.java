package tennis.tennisgame1;

public final class PlayerScoresAreEqualEvaluator implements ScoreEvaluator {

    @Override
    public String evaluateScore(Player player1, Player player2) {
        final int score1 = player1.getScore();
        final int score2 = player2.getScore();

        if (score1 == score2) {
            return switch (score1) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "tennis.Deuce";
            };
        }

        return null;
    }
}
