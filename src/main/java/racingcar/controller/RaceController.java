package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.car.WinnerDto;
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
        OutputView.printCarsPositionPrompt();
        while (round.canNext()) {
            cars.moveAll(randomNumber);
            OutputView.printCarsPosition(cars.printAll());
            round.proceed();
        }
    }

    public void endRace() {
        List<WinnerDto> winners = cars.printWinners();
        OutputView.printWinners(winners);
    }

}
