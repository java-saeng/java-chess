package chess;

import java.util.function.BiFunction;

public enum Movement {
    UP((position, times) -> new Position(position.file().value(), position.rank().value() + times)),
    DOWN((position, times) -> new Position(position.file().value(), position.rank().value() - times)),
    RIGHT((position, times) -> new Position(position.file().value() + times, position.rank().value())),
    LEFT((position, times) -> new Position(position.file().value() - times, position.rank().value())),
    RIGHT_UP((position, times) -> new Position(position.file().value() + times, position.rank().value() + times)),
    RIGHT_DOWN((position, times) -> new Position(position.file().value() + times, position.rank().value() - times)),
    LEFT_UP((position, times) -> new Position(position.file().value() - times, position.rank().value() + times)),
    LEFT_DOWN((position, times) -> new Position(position.file().value() - times, position.rank().value() - times)),
    ;

    private final BiFunction<Position, Integer, Position> moveFunction;

    Movement(final BiFunction<Position, Integer, Position> moveFunction) {
        this.moveFunction = moveFunction;
    }

    public Position from(Position position, int times) {
        return moveFunction.apply(position, times);
    }
}
