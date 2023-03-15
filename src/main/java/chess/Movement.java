package chess;

import java.util.function.Function;

public enum Movement {
    UP(position -> new Position(position.file().value(), position.rank().value() + 1)),
    DOWN(position -> new Position(position.file().value(), position.rank().value() - 1)),
    RIGHT(position -> new Position(position.file().value() + 1, position.rank().value())),
    LEFT(position -> new Position(position.file().value() - 1, position.rank().value())),
    RIGHT_UP(position -> new Position(position.file().value() + 1, position.rank().value() + 1)),
    RIGHT_DOWN(position -> new Position(position.file().value() + 1, position.rank().value() - 1)),
    LEFT_UP(position -> new Position(position.file().value() - 1, position.rank().value() + 1)),
    LEFT_DOWN(position -> new Position(position.file().value() - 1, position.rank().value() - 1)),
    ;

    private final Function<Position, Position> moveFunction;

    Movement(final Function<Position, Position> moveFunction) {
        this.moveFunction = moveFunction;
    }

    public Position from(Position position) {
        return moveFunction.apply(position);
    }
}
