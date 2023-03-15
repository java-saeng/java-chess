package chess.piece;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QueenTest {

    @Test
    @DisplayName("moveTo() : 다음 위치에 성공적으로 움직일 수 있다.")
    void test_moveTo_success() throws Exception {
        //given
        Piece queen = new Queen(Color.BLACK, new Position(4, 1));

        //when & then
        assertThat(queen.moveTo(new Position(7, 4)))
                .isEqualTo(new Queen(Color.BLACK, new Position(7, 4)));
    }

    @Test
    @DisplayName("moveTo() : 해당 말은 다음 위치에 성공적으로 움직일 수 없다.")
    void test_moveTo_exception() throws Exception {
        //given
        Piece queen = new Queen(Color.BLACK, new Position(4, 1));

        //when & then
        assertThatThrownBy(() -> queen.moveTo(new Position(7, 3)))
                .isInstanceOf(IllegalStateException.class);
    }
}
