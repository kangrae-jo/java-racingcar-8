package racingcar.domain.car;

import racingcar.domain.random.Dice;

public class Car {

    private final static int INIT_POSITION = 0;
    private final static int MOVE_AMOUNT = 1;
    private final static int THRESHOLD = 4;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(INIT_POSITION);
    }

    public void attemptToMove(Dice dice) {
        if (dice.canMove(THRESHOLD)) {
            position.move(MOVE_AMOUNT);
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

}
