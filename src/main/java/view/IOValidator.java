package view;

public class IOValidator {

    private static final String REGEX_INTEGER = "^(0|-?[1-9][0-9]*)$";

    public static void validateStringToInteger(String value) {
        if (!value.matches(REGEX_INTEGER)) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }
}
