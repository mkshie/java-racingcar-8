package racingcar.racing.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.racing.ui.OutputView;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(List<String> names, int tryCount) {
        validateTryCount(tryCount);
        this.cars = toCars(names);
        this.tryCount = tryCount;
    }

    public void playEachRound(OutputView output) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                int pickNumber = Randoms.pickNumberInRange(0, 9);
                car.tryMove(pickNumber);
            }
            output.printRound(cars);
        }
    }

    public List<String> findWinners() {
        int max = cars.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElse(0);

        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private static List<Car> toCars(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }
        List<Car> list = new ArrayList<>();
        for (String n : names) {
            list.add(new Car(n));
        }
        return list;
    }
}
