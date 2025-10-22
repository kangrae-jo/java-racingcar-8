package racingcar.domain.car;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int move(int step) {
        return this.position += step;
    }

    @Override
    public String toString() {
        return "-".repeat(position);
    }

}
