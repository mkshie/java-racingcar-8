package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전원_공동_우승_테스트() {
        // 한 라운드에서 모두 정지 → 전원 공동 우승
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b", "1");
                    assertThat(output())
                            .contains("a : ")
                            .contains("b : ")
                            .contains("최종 우승자 : a, b");
                },
                STOP, STOP
        );
    }

    @Test
    void 입력_공백허용_정상_테스트() {
        // 이름/횟수에 공백이 있어도 정상 파싱되어 동작
        assertRandomNumberInRangeTest(
                () -> {
                    run("  a ,  b  ", " 2 ");
                    assertThat(output())
                            .contains("실행 결과")
                            .contains("최종 우승자 : a, b"); // 난수 시퀀스에 따라 공동 우승
                },
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트_빈토큰() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_빈횟수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
