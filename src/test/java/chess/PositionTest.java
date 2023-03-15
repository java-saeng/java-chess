package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("calculateUnitMovement(position) : position값을 뺀 movement반환")
    void calculateUnitMovement() {
        final Position position1 = new Position(2, 1);
        final Position position2 = new Position(6, 3);

        final Movement movement = position2.calculateUnitMovement(position1);

        assertThat(movement).isEqualTo(Movement.RRU);
    }
}
