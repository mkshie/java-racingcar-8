package racingcar.racing.ui;

import java.util.ArrayList;
import java.util.List;

public class NameParser {
    private static final String SEP = ",";
    private static final int MAX_LEN = 5;


    public static List<String> parse(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("이름이 null 입니다. 제대로 입력해주세요");
        }
        String trimmed = raw.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어 있습니다.");
        }

        String[] tokens = trimmed.split(SEP, -1);

        List<String> names = new ArrayList<>();
        for (String t : tokens) {
            String name = t.trim();
            validateName(name);
            names.add(name);
        }
        return names;
    }

    private static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
        }
        int len = name.length();
        if (len > MAX_LEN) {
            throw new IllegalArgumentException("이름 길이는 5자 이하여야 합니다: " + name);
        }
    }
}
