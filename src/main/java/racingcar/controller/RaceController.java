package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.number.RandomNumber;
import racingcar.domain.round.Round;

public class RaceController {

    private final RandomNumber randomNumber;
    private final Cars cars;
    private final Round round;

    public RaceController(RandomNumber randomNumber, Cars cars, Round round) {
        this.randomNumber = randomNumber;
        this.cars = cars;
        this.round = round;
    }

    public void startRace() {
        while (round.canNext()) {
            cars.moveAll(randomNumber);
            cars.printAll();
            round.proceed();
        }
    }

    public void endRace() {
        cars.printWinners();
    }

}
