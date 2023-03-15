package chess.piece;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KingTest {

    @Test
    @DisplayName("moveTo() : 다음 위치에 성공적으로 움직일 수 있다.")
    void test_moveTo_success() throws Exception {
        //given
        Piece king = new King(Color.BLACK, new Position(5, 2));

        //when & then
        assertThat(king.moveTo(new Position(6, 1)))
                .isEqualTo(new King(Color.BLACK, new Position(6, 1)));
    }

    @Test
    @DisplayName("moveTo() : 해당 말은 다음 위치에 성공적으로 움직일 수 없다.")
    void test_moveTo_exception() throws Exception {
        //given
        Piece king = new King(Color.BLACK, new Position(5, 1));

        //when & then
        assertThatThrownBy(() -> king.moveTo(new Position(7, 1)))
                .isInstanceOf(IllegalStateException.class);
    }
}
