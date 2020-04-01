package prisonerdilemma;

import java.util.Arrays;

import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.Tensors;
import ch.ethz.idsc.tensor.alg.Dimensions;
import ch.ethz.idsc.tensor.sca.Clip;
import ch.ethz.idsc.tensor.sca.Clips;
import core.Rule;

/** https://en.wikipedia.org/wiki/Prisoner%27s_dilemma */
public class PrisonersDilemmaRule implements Rule {
    private static final Tensor RULE = Tensors.of(Tensors.of(Tensors.vector(-1, -1), Tensors.vector(-3, 0)), Tensors.of(Tensors.vector(0, -3), Tensors.vector(-2, -2)));
    private static final Clip CLIP = Clips.interval(0, 2);

    @Override
    public boolean isValid(Tensor move) {
        return Dimensions.of(move).equals(Arrays.asList(2)) && move.stream().map(Scalar.class::cast).allMatch(i -> CLIP.isInside(i));
    }

    @Override
    public Tensor evaluate(Tensor move) {
        return RULE.get(move.Get(0).number().intValue(), move.Get(1).number().intValue());
    }

    @Override
    public Tensor evaluateMoves(Tensor moves) {
        return moves.stream().map(i -> evaluate(i)).reduce(Tensor::add).get();
    }
}
