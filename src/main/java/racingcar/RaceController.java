package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;

public class RaceController {

    private final RandomNumber randomNumber;
    private final Cars cars;
    private final Round round;

    public RaceController(RandomNumber randomNumber, List<Car> cars, Round round) {
        this.randomNumber = randomNumber;
        this.cars = new Cars(cars);
        this.round = round;
    }

    public void startRace() {
        while (round.canNext()) {
            cars.moveAll(randomNumber);
            round.proceed();
        }
        // TODO: winners를 리턴하는 방식 고려
    }

}
