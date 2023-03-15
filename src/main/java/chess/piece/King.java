package chess.piece;

import chess.Movement;
import chess.Position;

public class King extends Piece {

    public King(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Movement searchPossibleMovementFrom(final Position destination) {
        return null;
    }
}
