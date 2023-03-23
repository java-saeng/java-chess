package chess.domain.board;

import chess.domain.board.factory.BoardFactory;
import chess.domain.board.position.Path;
import chess.domain.board.position.Position;
import chess.domain.piece.Color;
import chess.domain.piece.Piece;

import java.util.Map;

public class Board {

    private final Map<Position, Piece> chessBoard;

    public Board(final BoardFactory boardFactory) {
        this.chessBoard = boardFactory.createInitialBoard();
    }

    public Board(final Map<Position, Piece> chessBoard) {
        this.chessBoard = Map.copyOf(chessBoard);
    }

    public void move(Position from, Position to, final Color nextTurn) {
        final Piece currentMovePiece = findPieceFrom(from);

        validateMoveFromEmpty(currentMovePiece);
        validateTurn(currentMovePiece, nextTurn);

        final Path path = currentMovePiece.searchPathTo(from, to, findPieceFrom(to));

        validateObstacle(path);
        movePiece(from, to);
    }

    private Piece findPieceFrom(final Position position) {
        return chessBoard.get(position);
    }

    private void validateMoveFromEmpty(final Piece piece) {
        if (piece == null) {
            throw new IllegalArgumentException("출발점에 말이 없습니다.");
        }
    }

    private void validateTurn(final Piece currentTurnPiece, final Color nextTurn) {
        if (currentTurnPiece.isDifferentColor(nextTurn)) {
            throw new IllegalArgumentException("차례에 맞는 말을 선택해 주세요");
        }
    }

    private void validateObstacle(final Path path) {
        if (path.hasIntersection(chessBoard.keySet())) {
            throw new IllegalStateException("중간에 다른 기물이 존재합니다.");
        }
    }

    private void movePiece(final Position from, final Position to) {
        final Piece movingPiece = chessBoard.remove(from);
        chessBoard.put(to, movingPiece);
    }

    public Map<Position, Piece> chessBoard() {
        return Map.copyOf(chessBoard);
    }
}
