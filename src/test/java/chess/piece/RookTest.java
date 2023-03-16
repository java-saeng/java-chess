package chess.piece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.Path;
import chess.Position;
import java.util.Optional;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

class RookTest {

    @Test
    void test_searchPathTo() {
        Piece Rook = new Rook(Color.WHITE);

        Position initialPosition = new Position(5, 1);
        Path path = Rook.searchPathTo(initialPosition, new Position(5, 8), Optional.empty());

        assertThat(path)
                .extracting("positions", InstanceOfAssertFactories.list(Position.class))
                .containsExactly(
                        new Position(5, 2), new Position(5, 3),
                        new Position(5, 4), new Position(5, 5),
                        new Position(5, 6), new Position(5, 7));
    }

    @Test
    void test_searchPathTo2() {
        Rook Rook = new Rook(Color.WHITE);

        Position initialPosition = new Position(5, 5);
        Path path = Rook.searchPathTo(initialPosition, new Position(5, 1), Optional.empty());

        assertThat(path)
                .extracting("positions", InstanceOfAssertFactories.list(Position.class))
                .containsExactly(
                        new Position(5, 4),
                        new Position(5, 3),
                        new Position(5, 2));
    }

    @Test
    void test_searchPathTo3() {
        Rook Rook = new Rook(Color.WHITE);

        Position initialPosition = new Position(5, 5);

        assertThatThrownBy(
                () -> Rook.searchPathTo(initialPosition,
                        new Position(5, 1),
                        Optional.of(new King(Color.WHITE))))
                .isInstanceOf(IllegalStateException.class);
    }
}
