package chess.piece;

import chess.Movement;
import chess.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Knight extends Piece {

    private static final int MOVEMENT_UNIT = 1;

    public Knight(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    protected Piece moveTo(final Position next) {

        if (canNotMove(next)) {
            throw new IllegalStateException("Knight는 L자로 움직일 수 있습니다.");
        }

        return new Knight(color, next);
    }

    private boolean canNotMove(final Position next) {

        List<List<Movement>> movements = List.of(
                List.of(Movement.UP, Movement.UP, Movement.RIGHT),
                List.of(Movement.UP, Movement.UP, Movement.LEFT),
                List.of(Movement.RIGHT, Movement.RIGHT, Movement.UP),
                List.of(Movement.RIGHT, Movement.RIGHT, Movement.DOWN),
                List.of(Movement.DOWN, Movement.DOWN, Movement.LEFT),
                List.of(Movement.DOWN, Movement.DOWN, Movement.RIGHT),
                List.of(Movement.LEFT, Movement.LEFT, Movement.UP),
                List.of(Movement.LEFT, Movement.LEFT, Movement.DOWN)
        );

        List<Position> candidates = new ArrayList<>();

        for (final List<Movement> movement : movements) {

            boolean flag = false;
            Position finalPosition = position;

            for (Movement movement1 : movement) {
                if (isMovable(finalPosition, movement1)) {
                    finalPosition = movement1.from(finalPosition, MOVEMENT_UNIT);
                } else {
                    flag = true;
                }
            }

            if (!flag) {
                candidates.add(finalPosition);
            }
        }

//        final List<Position> collect = movements.stream()
//                                                .map(movementList -> movementList.stream()
//                                                                                 .filter(isMovable())
//                                                                                 .reduce(position,
//                                                                                         (position1, movement) -> movement.from(position1, 1),
//                                                                                         (p1, p2) -> p2))
//                                                .collect(Collectors.toList());

//        System.out.println("collect = " + collect);

        return !candidates.contains(next);
    }

    private boolean isMovable(Position position, Movement movement) {
        try {
            movement.from(position, MOVEMENT_UNIT);
        } catch (NoSuchElementException exception) {
            return false;
        }
        return true;
    }

    private Predicate<Movement> isMovable() {
        return movement -> {
            try {
                movement.from(position, MOVEMENT_UNIT);
            } catch (NoSuchElementException exception) {
                return false;
            }
            return true;
        };
    }
}
