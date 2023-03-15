package chess.piece;

import chess.Position;

public class Pawn extends Piece {

    public Pawn(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Piece moveTo(final Position next) {
        return null;
    }
}
