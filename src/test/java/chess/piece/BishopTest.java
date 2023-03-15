package chess.piece;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BishopTest {

    @Test
    @DisplayName("moveTo() : 다음 위치에 성공적으로 움직일 수 있다.")
    void test_moveTo_success() throws Exception {
        //given
        Piece bishop = new Bishop(Color.BLACK, new Position(3, 1));

        //when
        final Position next = new Position(8, 6);

        //then
        assertThat(bishop.moveTo(next))
                .isEqualTo(new Bishop(Color.BLACK, next));
    }

    @Test
    @DisplayName("moveTo() : 해당 말은 다음 위치에 성공적으로 움직일 수 없다.")
    void test_moveTo_exception() throws Exception {
        //given
        Piece bishop = new Bishop(Color.BLACK, new Position(3, 1));

        //when & then
        assertThatThrownBy(() -> bishop.moveTo(new Position(8, 8)))
                .isInstanceOf(IllegalStateException.class);
    }
}
