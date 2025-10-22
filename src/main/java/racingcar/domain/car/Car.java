package racingcar.domain.car;

import racingcar.domain.number.RandomNumber;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void attemptToMove(RandomNumber randomNumber) {
        if (randomNumber.canMove(4)) {
            position.move(1);
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }

}
