package chess.piece;

import chess.Movement;
import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    @DisplayName("searchPossibleCatchFrom (Position) : position에 있는 piece를 잡을 수 있다.")
    void test_searchPossibleCatchFrom() {
        //given
        final Pawn pawn = new Pawn(Color.WHITE, new Position(1, 2));
        final Position destination = new Position(2, 3);

        //when
        final Movement movement = pawn.searchPossibleCatchFrom(destination);

        //then
        assertThat(movement).isEqualTo(Movement.UR);
    }
}
