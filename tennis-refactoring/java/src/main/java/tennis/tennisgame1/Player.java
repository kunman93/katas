package tennis.tennisgame1;

public final class Player {
    private int score;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementScoreByOne() {
        score++;
    }
}
