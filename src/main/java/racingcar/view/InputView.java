package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readCarNames() {
        OutputView.printCarNamePrompt();
        return Console.readLine();
    }

    public static String readTotalRound() {
        OutputView.printRoundPrompt();
        return Console.readLine();
    }

}
