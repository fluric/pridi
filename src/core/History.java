package core;

import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.Tensors;
import ch.ethz.idsc.tensor.alg.Dimensions;

public class History {
    private Tensor moves;

    public History() {
        this(Tensors.empty());
    }

    public History(Tensor moves) {
        this.moves = moves;
    }

    public Tensor getAllMoves() {
        return moves;
    }

    public Tensor getMove(int move) {
        assert (moves.length() > move);
        return moves.get(move);
    }

    public int getHistoryLength() {
        return moves.length();
    }

    public void addMove(Tensor move) {
        assert (Dimensions.of(move).get(0) == 1);
        assert (moves.length() == 0 || Dimensions.of(moves).get(1) == move.length());
        moves.append(move);
    }
}
