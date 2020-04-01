package prisonerdilemma;

import ch.ethz.idsc.tensor.RealScalar;
import core.History;
import core.Player;

public class ResentfulPlayerPD implements Player {

    @Override
    public int move(History history, int position) {
        int opPos = position == 0 ? 1 : 0;
        return history.getAllMoves().stream().anyMatch(i -> i.Get(opPos).equals(RealScalar.ONE)) ? 1 : 0;
    }

}
