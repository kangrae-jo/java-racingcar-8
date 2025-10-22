package racingcar.domain.car;

import java.util.List;
import racingcar.domain.number.RandomNumber;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(RandomNumber randomNumber) {
        cars.forEach(car -> {
            randomNumber.refresh();
            car.attemptToMove(randomNumber);
        });
    }

}
