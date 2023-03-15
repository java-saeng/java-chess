package chess.piece;

import chess.Movement;
import chess.Position;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Queen extends Piece {

    public Queen(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Piece moveTo(final Position next) {

        if (canNotMove(next)) {
            throw new IllegalStateException("Queen은 8방향 원하는 만큼 움직일 수 있습니다.");
        }

        return new Queen(color, next);
    }

    private boolean canNotMove(final Position next) {
        return IntStream.rangeClosed(1, 8)
                        .boxed()
                        .flatMap(step -> Arrays.stream(Movement.values())
                                               .filter(isMovableBy(step))
                                               .map(movement -> movement.from(position, step)))
                        .noneMatch(it -> it.equals(next));
    }

    private Predicate<Movement> isMovableBy(int step) {
        return movement -> {
            try {
                movement.from(position, step);
            } catch (NoSuchElementException exception) {
                return false;
            }
            return true;
        };
    }
}
