package chess.piece;

import chess.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KnightTest {

    @Test
    @DisplayName("moveTo() : 위 오른쪽으로 움직일 수 있다.")
    void test_moveTo_up_right() throws Exception {
        //given
        Piece knight = new Knight(Color.BLACK, new Position(2, 1));

        //when & then
        final Position next = new Position(3, 3);
        assertThat(knight.moveTo(next))
                .isEqualTo(new Knight(Color.BLACK, next));
    }

    @Test
    @DisplayName("moveTo() : 위 왼쪽으로 움직일 수 있다.")
    void test_moveTo_up_left() throws Exception {
        //given
        Piece knight = new Knight(Color.BLACK, new Position(2, 1));

        //when & then
        final Position next = new Position(1, 3);
        assertThat(knight.moveTo(next))
                .isEqualTo(new Knight(Color.BLACK, next));
    }
    @Test
    @DisplayName("moveTo() : 오른쪽 위로 움직일 수 있다.")
    void test_moveTo_right_up() throws Exception {
        //given
        Piece knight = new Knight(Color.BLACK, new Position(2, 1));

        //when & then
        final Position next = new Position(4,2);
        assertThat(knight.moveTo(next))
                .isEqualTo(new Knight(Color.BLACK, next));
    }
    @Test
    @DisplayName("moveTo() : 해당 말은 다음 위치에 성공적으로 움직일 수 없다.")
    void test_moveTo_exception() throws Exception {
        //given
        Piece knight = new Knight(Color.BLACK, new Position(2, 1));

        //when & then
        assertThatThrownBy(() -> knight.moveTo(new Position(7, 3)))
                .isInstanceOf(IllegalStateException.class);
    }

}
