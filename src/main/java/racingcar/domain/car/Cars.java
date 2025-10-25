package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.dto.CarDto;
import racingcar.domain.car.dto.WinnerDto;
import racingcar.domain.random.Dice;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        this.cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .toList();
    }

    public void moveAll(Dice dice) {
        cars.forEach(car -> {
            dice.reroll();
            car.attemptToMove(dice);
        });
    }

    public List<CarDto> toCarDtos() {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }

    public List<WinnerDto> toWinnerDtos() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(WinnerDto::from)
                .collect(Collectors.toList());
    }

}
