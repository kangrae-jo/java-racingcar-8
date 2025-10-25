package racingcar.domain.car.dto;

import racingcar.domain.car.Car;

public record WinnerDto(String name) {

    public static WinnerDto from(Car car) {
        return new WinnerDto(car.getName());
    }

}
