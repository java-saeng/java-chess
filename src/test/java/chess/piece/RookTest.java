package chess.piece;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RookTest {

    @Test
    @DisplayName("moveTo() : 다음 위치에 성공적으로 움직일 수 있다.")
    void test_moveTo_success() throws Exception {
        //given
        Piece rook = new Rook(Color.BLACK, new Position(1, 1));

        //when & then
        assertThat(rook.moveTo(new Position(7, 1)))
                .isEqualTo(new Rook(Color.BLACK, new Position(7, 1)));
    }

    @Test
    @DisplayName("moveTo() : 해당 말은 다음 위치에 성공적으로 움직일 수 없다.")
    void test_moveTo_exception() throws Exception {
        //given
        Piece rook = new Rook(Color.BLACK, new Position(1, 1));

        //when & then
        assertThatThrownBy(() -> rook.moveTo(new Position(7, 3)))
                .isInstanceOf(IllegalStateException.class);
    }
}
