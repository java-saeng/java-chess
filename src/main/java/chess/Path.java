package chess;

import java.util.List;

public class Path {

    private final List<Position> positions;

    public Path(final List<Position> positions) {
        this.positions = List.copyOf(positions);
    }
}
