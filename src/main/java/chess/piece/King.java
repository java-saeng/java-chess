package chess.piece;

import chess.Movement;
import chess.Position;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class King extends Piece {

    public King(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Piece moveTo(final Position next) {

        final boolean canNotMove = Arrays.stream(Movement.values())
                                         .filter(throwsException())
                                         .map(movement -> movement.from(position))
                                         .noneMatch(it -> it.equals(next));

        if (canNotMove) {
            throw new IllegalStateException("King은 8방향 1칸씩만 움직일 수 있습니다.");
        }

        return new King(color, next);
    }

    private Predicate<Movement> throwsException() {
        return movement -> {
            try {
                movement.from(position);
            } catch (NoSuchElementException exception) {
                return false;
            }
            return true;
        };
    }
}
