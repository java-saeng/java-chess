package chess.domain.piece;

import chess.domain.board.position.Path;
import chess.domain.board.position.Position;
import java.util.Optional;

public abstract class Piece {

    protected final Color color;

    protected Piece(final Color color) {
        this.color = color;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public abstract Path searchPathTo(Position from, Position to, Optional<Piece> destination);

    protected void validateSameColor(Piece other) {
        if (color.isSameColor(other.color)) {
            throw new IllegalStateException("같은 색 말의 위치로 이동할 수 없습니다.");
        }
    }

    public boolean isSameColor(Color turn) {
        return color.isSameColor(turn);
    }
}