package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.dto.CarDto;
import racingcar.domain.car.dto.WinnerDto;

public class OutputView {

    public static void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRoundPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printCarsPositionPrompt() {
        System.out.println("\n실행결과");
    }

    public static void printCarsPosition(List<CarDto> carDtos) {
        carDtos.forEach(carDto ->
                System.out.println(carDto.name() + " : " + "-".repeat(carDto.position()))
        );
        System.out.println();
    }

    public static void printWinners(List<WinnerDto> winnerDtos) {
        String winnerNames = winnerDtos.stream()
                .map(WinnerDto::name)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);

    }

}
