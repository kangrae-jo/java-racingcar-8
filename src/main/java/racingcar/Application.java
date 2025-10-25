package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;
import racingcar.domain.car.Cars;
import racingcar.domain.random.Dice;
import racingcar.domain.round.Round;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String names = InputView.readCarNames();
        Cars cars = new Cars(names);

        String totalRound = InputView.readTotalRound();
        Round round = new Round(totalRound);
        Console.close();

        RaceController controller = new RaceController(new Dice(), cars, round);
        controller.startRace();
        controller.endRace();
    }

}
