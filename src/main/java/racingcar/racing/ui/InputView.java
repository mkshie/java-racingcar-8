package racingcar.racing.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raw = Console.readLine();
        return parsePositiveInt(raw);
    }

    private int parsePositiveInt(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("시도 횟수가 null입니다.");
        }
        String t = raw.trim();
        if (t.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수가 비어 있습니다.");
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
            }
        }
        int val = Integer.parseInt(t);
        if (val <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return val;
    }
}
