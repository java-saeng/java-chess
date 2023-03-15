package chess.piece;

import chess.Movement;
import chess.Path;
import chess.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bishop extends Piece {

    public Bishop(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Map<Piece, Path> moveTo(final Position next) {

        final Path positionCandidates = createPositionCandidates(next);

        return new HashMap<>(){{
            put()
        }};
    }

    public boolean canMove(final Position next) {
        final Map<Piece, Path> piecePathMap = moveTo(next);

        return piecePathMap.size() == 0;
    }

//    private boolean canNotMove(final Position next) {
//
//        final List<Movement> movements = List.of(
//                Movement.RIGHT_UP, Movement.RIGHT_DOWN,
//                Movement.LEFT_UP, Movement.LEFT_DOWN
//        );
//
//        return IntStream.rangeClosed(1, 8)
//                        .boxed()
//                        .flatMap(step -> movements.stream()
//                                                  .filter(isMovableBy(step))
//                                                  .map(movement -> movement.from(position, step)))
//                        .noneMatch(it -> it.equals(next));
//    }

    private Path createPositionCandidates(final Position next) {

        final List<Movement> movements = List.of(
                Movement.RIGHT_UP, Movement.RIGHT_DOWN,
                Movement.LEFT_UP, Movement.LEFT_DOWN
        );

        return new Path(IntStream.rangeClosed(1, 8)
                                 .boxed()
                                 .flatMap(step -> movements.stream()
                                                           .filter(isMovableBy(step))
                                                           .map(movement -> movement.from(position, step)))
                                 .filter(it -> it.equals(next))
                                 .collect(Collectors.toList()));
    }

    private Predicate<Movement> isMovableBy(int step) {
        return movement -> {
            try {
                movement.from(position, step);
            } catch (NoSuchElementException exception) {
                return false;
            }
            return true;
        };
    }
}
