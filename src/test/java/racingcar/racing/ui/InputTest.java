package racingcar.racing.ui;


import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    void 쉼표로_파싱되고_공백제외() {
        assertThat(NameParser.parse(" pobi, woni ,jun "))
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 빈토큰은_예외() {
        assertThatThrownBy(() -> NameParser.parse("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈토큰은_예외_2() {
        assertThatThrownBy(() -> NameParser.parse(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_초과_예외() {
        assertThatThrownBy(() -> NameParser.parse("toolong,ok"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readTryCount_양의정수() {
        setInput("5\n");
        InputView view = new InputView();

        assertThat(view.readTryCount()).isEqualTo(5);
    }

    @Test
    void readTryCount_0이면_예외() {
        setInput("0\n");
        InputView view = new InputView();

        assertThatThrownBy(view::readTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readTryCount_음수면_예외() {
        setInput("-1\n");
        InputView view = new InputView();

        assertThatThrownBy(view::readTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readTryCount_숫자아님_예외() {
        setInput("1a\n");
        InputView view = new InputView();

        assertThatThrownBy(view::readTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readTryCount_빈값이면_예외() {
        setInput("\n");
        InputView view = new InputView();

        assertThatThrownBy(view::readTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readTryCount_공백_허용() {
        setInput("   10   \n");
        InputView view = new InputView();

        assertThat(view.readTryCount()).isEqualTo(10);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }
    @AfterEach
    void tearDown(){ Console.close(); }

}
