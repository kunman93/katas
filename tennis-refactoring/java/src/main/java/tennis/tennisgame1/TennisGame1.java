package tennis.tennisgame1;

import tennis.TennisGame;

import java.util.List;

public class TennisGame1 implements TennisGame {
    private final Player player1;
    private final Player player2;
    private final List<ScoreEvaluator> scoreEvaluators;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);

        scoreEvaluators = List.of(
            new PlayerScoresAreEqualEvaluator(),
            new PlayerScoreGreaterOrEqualFourEvaluator(),
            new PlayerScoreLessThanFourEvaluator()
        );
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName)) {
            player1.incrementScoreByOne();
        } else {
            player2.incrementScoreByOne();
        }
    }

    public String getScore() {
        for (ScoreEvaluator scoreEvaluator : scoreEvaluators) {
            final String score = scoreEvaluator.evaluateScore(player1, player2);

            if (score != null) {
                return score;
            }
        }

        return null;
    }
}
