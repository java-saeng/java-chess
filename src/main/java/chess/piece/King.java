package chess.piece;

import chess.Movement;
import chess.Position;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class King extends Piece {

    private static final int MOVEMENT_UNIT = 1;

    public King(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Piece moveTo(final Position next) {

        if (canNotMove(next)) {
            throw new IllegalStateException("King은 8방향 1칸씩만 움직일 수 있습니다.");
        }

        return new King(color, next);
    }

    private boolean canNotMove(final Position next) {
        return Arrays.stream(Movement.values())
                     .filter(isMovable())
                     .map(movement -> movement.from(position, MOVEMENT_UNIT))
                     .noneMatch(it -> it.equals(next));
    }

    private Predicate<Movement> isMovable() {
        return movement -> {
            try {
                movement.from(position, MOVEMENT_UNIT);
            } catch (NoSuchElementException exception) {
                return false;
            }
            return true;
        };
    }
}
