package racingcar.domain.car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.car.dto.CarDto;
import racingcar.domain.car.dto.WinnerDto;
import racingcar.domain.random.Dice;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        String[] splitNames = names.split(",");

        validateUniqueNames(splitNames);
        this.cars = Arrays.stream(splitNames)
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

    private void validateUniqueNames(String[] splitNames) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(splitNames));

        if (uniqueNames.size() != splitNames.length) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

}
