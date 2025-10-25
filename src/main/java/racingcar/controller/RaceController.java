package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.random.Dice;
import racingcar.domain.round.Round;
import racingcar.view.OutputView;

public class RaceController {

    private final Dice dice;
    private final Cars cars;
    private final Round round;

    public RaceController(Dice dice, Cars cars, Round round) {
        this.dice = dice;
        this.cars = cars;
        this.round = round;
    }

    public void startRace() {
        OutputView.printCarsPositionPrompt();
        while (round.canNext()) {
            cars.moveAll(dice);
            OutputView.printCarsPosition(cars.toCarDtos());
            round.proceed();
        }
    }

    public void endRace() {
        OutputView.printWinners(cars.toWinnerDtos());
    }

}
