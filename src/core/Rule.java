package core;

import ch.ethz.idsc.tensor.Tensor;

public interface Rule {
    boolean isValid(Tensor move);

    Tensor evaluate(Tensor move);

    Tensor evaluateMoves(Tensor moves);
}
