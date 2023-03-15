package chess.piece;

import chess.Movement;
import chess.Position;
import chess.Rank;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Pawn extends Piece {
    private static final Map<Color, List<Movement>> CATCHABLE_MOVEMENT = Map.of(
            Color.BLACK, List.of(Movement.UR, Movement.UL),
            Color.WHITE, List.of(Movement.DR, Movement.DL)
    );
    private static final Map<Color, Movement> BLANK_MOVEMENT = Map.of(
            Color.BLACK, Movement.D,
            Color.WHITE, Movement.U
    );
    private static final Map<Color, Predicate<Rank>> isMoved = Map.of(
            Color.BLACK, (rank) -> Rank.SEVEN.equals(rank),
            Color.WHITE, (rank) -> Rank.TWO.equals(rank)
    );

    public Pawn(final Color color, final Position position) {
        super(color, position);
    }

    @Override
    public Movement searchPossibleMovementFrom(final Position destination) {
        final Movement movement = destination.calculateUnitMovement(position);

        final int diff = position.subRankAndFileAbs(destination);

        if (diff > 2) {
            throw new IllegalArgumentException();
        }



        if (CATCHABLE_MOVEMENT.get(color).equals(Movement)) {

        }

        throw new IllegalArgumentException();
    }

    public Movement searchPossibleCatchFrom(final Position destination) {
        final Movement movement = destination.calculateUnitMovement(position);

        if (position.subRankAndFileAbs(destination) != 2) {
            throw new IllegalStateException();
        }
        return CATCHABLE_MOVEMENT.get(color).stream()
                                 .filter(movement::equals)
                                 .findAny()
                                 .orElseThrow(() -> new IllegalArgumentException());
    }
}
