package chess.piece;

import chess.Movement;
import chess.Position;

public class Knight extends Piece {

    private static final int MOVEMENT_UNIT = 1;

    public Knight(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Movement searchPossibleMovementFrom(final Position destination) {
        return null;
    }
}
