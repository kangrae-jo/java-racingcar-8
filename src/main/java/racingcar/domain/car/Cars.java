package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.number.RandomNumber;

public class Cars {

    private final List<Car> cars;

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

    public List<CarDto> printAll() {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }

    public String printWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
