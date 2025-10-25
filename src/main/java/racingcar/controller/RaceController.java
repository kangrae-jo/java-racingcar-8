package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.number.RandomNumber;
import racingcar.domain.round.Round;
import racingcar.view.OutputView;

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
        StringBuilder raceResult = new StringBuilder();
        while (round.canNext()) {
            cars.moveAll(randomNumber);
            raceResult.append(cars.printAll());
            round.proceed();
        }

        OutputView.printCarsPosition(raceResult.toString());
    }

    public void endRace() {
        cars.printWinners();
    }

}
