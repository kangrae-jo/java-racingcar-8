package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.number.RandomNumber;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String names) {
        this.cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .toList();
    }

    public void moveAll(RandomNumber randomNumber) {
        cars.forEach(car -> {
            randomNumber.refresh();
            car.attemptToMove(randomNumber);
        });
    }

    public void printAll() {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

}
