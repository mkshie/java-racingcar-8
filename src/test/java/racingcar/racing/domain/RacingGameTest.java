package racingcar.racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void 시도횟수_예외_테스트_0(){
        List<String> names = List.of("a","b");
        assertThatThrownBy(() -> new RacingGame(names,0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_예외_테스트_음수(){
        List<String> names = List.of("a","b");
        assertThatThrownBy(() -> new RacingGame(names,-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_빈목록_예외_테스트() {
        assertThatThrownBy(() -> new RacingGame(List.of(), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_1_정상() {
        assertThatCode(() -> new RacingGame(List.of("a","b"), 1))
                .doesNotThrowAnyException();
    }
}
