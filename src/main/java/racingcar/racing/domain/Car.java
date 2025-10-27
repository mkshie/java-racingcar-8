package racingcar.racing.domain;

public class Car {
    private final String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    public void tryMove(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    public String render() {
        return name + " : " + "-".repeat(position);
    }
}
