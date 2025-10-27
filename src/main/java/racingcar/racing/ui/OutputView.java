package racingcar.racing.ui;

import java.util.List;
import racingcar.racing.domain.Car;

public class OutputView {
    public void printExecutionHeader() {
        System.out.println("\n실행 결과");
    }

    public void printRound(List<Car> cars) {
        for (Car c : cars) {
            System.out.println(c.render());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
