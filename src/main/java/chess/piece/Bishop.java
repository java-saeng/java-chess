package chess.piece;

import chess.Movement;
import chess.Position;

public class Bishop extends Piece {

    public Bishop(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Movement searchPossibleMovementFrom(final Position destination) {
        return null;
    }

}
