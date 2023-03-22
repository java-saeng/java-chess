package chess.view;

import java.util.Arrays;

public enum Command {

    START("start"),
    MOVE("move"),
    END("end"),
    STATUS("status");

    private final String value;

    Command(final String value) {
        this.value = value;
    }

    public static boolean isEnd(String command) {
        return Arrays.stream(values())
                     .filter(it -> it == END)
                     .anyMatch(it -> it.value.equals(command));
    }

    public static boolean isMove(String command) {
        return Arrays.stream(values())
                     .filter(it -> it == MOVE)
                     .anyMatch(it -> it.value.equals(command));
    }

    public static boolean isNotStart(String command) {
        return Arrays.stream(values())
                     .anyMatch(it -> it.value.equals(command) && !command.equals(START.value));
    }

    public static boolean isNotAppropriate(String command) {
        return Arrays.stream(values())
                     .filter(it -> it != MOVE)
                     .noneMatch(it -> it.value.equals(command));
    }

    public static boolean isStatus(final String command) {
        return Arrays.stream(values())
                     .filter(it -> it == STATUS)
                     .anyMatch(it -> it.value.equals(command));
    }
}
