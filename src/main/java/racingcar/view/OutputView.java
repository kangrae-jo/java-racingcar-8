package racingcar.view;

import java.util.List;
import racingcar.domain.car.CarDto;

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

    public static void printCarsPosition(List<CarDto> cars) {
        cars.forEach(car ->
                System.out.println(car.name() + " : " + "-".repeat(car.position()))
        );
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners);
    }

}
