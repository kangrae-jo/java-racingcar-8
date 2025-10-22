package racingcar;

public class Position {

    private int position;

    public Position() {
        this.position = 0;
    }

    public int move(int step) {
        return this.position += step;
    }
    
}
