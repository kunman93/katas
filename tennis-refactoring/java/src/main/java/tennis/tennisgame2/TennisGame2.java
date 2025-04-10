package tennis.tennisgame2;

import tennis.TennisGame;

import java.util.Map;

public class TennisGame2 implements TennisGame {
    private static final Map<Integer, String> RESULT_BY_SCORE = Map.of(
        0, "Love",
        1, "Fifteen",
        2, "Thirty",
        3, "Forty"
    );

    private final Player player1;
    private final Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore() {
        final var pointPlayer1 = player1.getPoint();
        final var pointPlayer2 = player2.getPoint();

        if (pointPlayer1 == pointPlayer2) {
            return switch (pointPlayer1) {
                case 0, 1, 2 -> RESULT_BY_SCORE.get(pointPlayer1) + "-All";
                default -> "Deuce";
            };
        } else if (pointPlayer1 <= 3 && pointPlayer2 <= 3) {
            return RESULT_BY_SCORE.get(pointPlayer1) + "-" + RESULT_BY_SCORE.get(pointPlayer2);
        } else {
            final int pointDifference = Math.abs(pointPlayer1 - pointPlayer2);
            final var leadingPlayer = pointPlayer1 > pointPlayer2 ? player1.getName() : player2.getName();

            return pointDifference == 1
                ? "Advantage " + leadingPlayer
                : "Win for " + leadingPlayer;
        }
    }

    public void wonPoint(String player) {
        if (player1.getName().equals(player)) {
            player1.incrementPointByOne();
        } else {
            player2.incrementPointByOne();
        }
    }
}