package chess.piece;

import chess.Movement;
import chess.Position;

public class Rook extends Piece {

    public Rook(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Movement searchPossibleMovementFrom(final Position destination) {
        return null;
    }

}
