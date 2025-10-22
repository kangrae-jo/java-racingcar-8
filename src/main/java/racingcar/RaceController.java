package racingcar;

import java.util.List;
import racingcar.car.Car;

public class RaceController {

    private final RandomNumber randomNumber;
    private final List<Car> cars;
    private final Round round;

    public RaceController(RandomNumber randomNumber, List<Car> cars, Round round) {
        this.randomNumber = randomNumber;
        this.cars = cars;
        this.round = round;
    }

    public void startRace() {
        while (round.canNext()) {
            // TODO: cars에게 각각의 car가 움직이게 하도록 메시지 전달
            //  ex) cars.moveAll();
            round.proceed();
        }
        // TODO: winners를 리턴하는 방식 고려
    }

}
