package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MovementTest {

    @Test
    @DisplayName("최소 이동단위(1만큼)로 움직일 수 있다.")
    void test_movement_from() throws Exception {
        //given
        Position position = new Position(5, 2);

        //when & then
        assertAll(
                () -> assertThat(Movement.UP.from(position)).isEqualTo(new Position(5, 3)),
                () -> assertThat(Movement.DOWN.from(position)).isEqualTo(new Position(5, 1)),
                () -> assertThat(Movement.RIGHT.from(position)).isEqualTo(new Position(6, 2)),
                () -> assertThat(Movement.LEFT.from(position)).isEqualTo(new Position(4, 2)),
                () -> assertThat(Movement.RIGHT_UP.from(position)).isEqualTo(new Position(6, 3)),
                () -> assertThat(Movement.RIGHT_DOWN.from(position)).isEqualTo(new Position(6, 1)),
                () -> assertThat(Movement.LEFT_UP.from(position)).isEqualTo(new Position(4, 3)),
                () -> assertThat(Movement.LEFT_DOWN.from(position)).isEqualTo(new Position(4, 1))
        );

    }
}
