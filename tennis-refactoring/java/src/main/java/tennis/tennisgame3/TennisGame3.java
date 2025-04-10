package tennis.tennisgame3;

import tennis.TennisGame;

public class TennisGame3 implements TennisGame {
    private static final String[] SCORES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private final Player player1;
    private final Player player2;

    public TennisGame3(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }

    public String getScore() {
        int pointPlayer1 = player1.getPoint();
        int pointPlayer2 = player2.getPoint();

        if (pointPlayer1 == pointPlayer2) {
            return switch (pointPlayer1) {
                case 0, 1, 2 -> SCORES[pointPlayer1] + "-All";
                default -> "Deuce";
            };
        } else if (pointPlayer1 < 4 && pointPlayer2 < 4) {
            return SCORES[pointPlayer1] + "-" + SCORES[pointPlayer2];
        } else {
            final var leadingPlayer = pointPlayer1 > pointPlayer2 ? player1.getName() : player2.getName();
            final var pointDifference = Math.abs(pointPlayer1 - pointPlayer2);
            return (pointDifference == 1)
                ? "Advantage " + leadingPlayer
                : "Win for " + leadingPlayer;
        }
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName)) {
            this.player1.incrementPointByOne();
        } else {
            this.player2.incrementPointByOne();
        }
    }

}
