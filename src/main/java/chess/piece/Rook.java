package chess.piece;

import chess.Movement;
import chess.Position;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Rook extends Piece {

    public Rook(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Piece moveTo(final Position next) {

        if (canNotMove(next)) {
            throw new IllegalStateException("Rook은 상하좌우 원하는 만큼 움직일 수 있습니다.");
        }

        return new Rook(color, next);
    }

    private boolean canNotMove(final Position next) {

        final List<Movement> movements = List.of(Movement.UP, Movement.DOWN, Movement.LEFT, Movement.RIGHT);

        return IntStream.rangeClosed(1, 8)
                        .boxed()
                        .flatMap(step -> movements.stream()
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
