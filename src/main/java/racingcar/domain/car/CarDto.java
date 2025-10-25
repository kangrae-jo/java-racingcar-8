package racingcar.domain.car;

public record CarDto(String name, int position) {

    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

}
