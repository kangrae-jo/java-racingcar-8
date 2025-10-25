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

    public String printAll() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n", "", "\n\n"));
    }

    public void printWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        String winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winners);
    }

}
