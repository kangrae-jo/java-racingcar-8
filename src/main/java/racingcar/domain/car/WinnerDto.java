package racingcar.domain.car;

public record WinnerDto(String name) {

    public static WinnerDto from(Car car) {
        return new WinnerDto(car.getName());
    }

}
