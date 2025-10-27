package racingcar;

import racingcar.racing.domain.RacingGame;
import racingcar.racing.ui.InputView;
import racingcar.racing.ui.NameParser;
import racingcar.racing.ui.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView input = new InputView();
        OutputView output = new OutputView();

        String rawNames = input.readNames();
        int tryCount = input.readTryCount();

        RacingGame game = new RacingGame(NameParser.parse(rawNames), tryCount);
        output.printExecutionHeader();

        game.playEachRound(output);
        output.printWinners(game.findWinners());

    }
}
