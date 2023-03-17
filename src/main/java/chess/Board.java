package chess;

import chess.piece.Color;
import chess.piece.Piece;

import java.util.Map;
import java.util.Optional;

public class Board {

    private final Map<Position, Piece> board;

    public Board(final BoardFactory boardFactory) {
        this.board = boardFactory.createInitialBoard();
    }

    public Map<Position, Piece> board() {
        return board;
    }

    public void move(Position from, Position to, final Color turn) {
        if (!board.get(from).isSameColor(turn)) {
            throw new IllegalArgumentException("차례에 맞는 말을 선택해 주세요");
        }
        validateIsFromEmpty(from);

        Path path = board.get(from)
                         .searchPathTo(from, to, Optional.ofNullable(board.get(to)));

        validateObstacle(path);
        Piece piece = board.remove(from);
        board.put(to, piece);
    }

    private void validateIsFromEmpty(final Position from) {
        if (!board.containsKey(from)) {
            throw new IllegalArgumentException("출발점에 말이 없습니다.");
        }
    }

    private void validateObstacle(final Path path) {
        if (path.hasIntersection(board.keySet())) {
            throw new IllegalStateException("중간에 다른 기물이 존재합니다.");
        }
    }
}
