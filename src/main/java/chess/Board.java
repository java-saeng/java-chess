package chess;

import chess.piece.Piece;

import java.util.Map;

public class Board {

    private final Map<Position, Piece> board;

    public Board(final BoardFactory boardFactory) {
        this.board = boardFactory.createInitialBoard();
    }

    public Map<Position, Piece> board() {
        return board;
    }

    public void move() {
        //next가 체스판 밖인지

        //next에 다른 얘가 있는지

        //내 팀인지 아닌지 == 잡을 수 있는지 없는지

        //(Piece) 이 피스가 움직일 수 있는 자리인지

    }
}
