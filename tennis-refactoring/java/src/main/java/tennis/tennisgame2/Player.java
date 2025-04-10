package tennis.tennisgame2;

public class Player {
    private int point;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void incrementPointByOne() {
        this.point++;
    }

    public String getName() {
        return name;
    }
}
