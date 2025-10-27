package racingcar.racing.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 값이_4_이상이면_전진(){
        Car car = new Car("pobi");
        car.tryMove(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값_3_이하면_정지() {
        Car car = new Car("pobi");
        car.tryMove(3);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 렌더링_결과_확인() {
        Car car = new Car("a");
        car.tryMove(9);
        car.tryMove(9);
        assertThat(car.render()).isEqualTo("a : --");
    }
}
