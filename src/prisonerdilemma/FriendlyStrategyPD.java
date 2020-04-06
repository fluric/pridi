package prisonerdilemma;

import core.History;
import core.Move;
import core.PlayerPosition;
import core.Strategy;

/** This strategy always chooses the cooperative way to stay silent */
public class FriendlyStrategyPD implements Strategy {

    @Override
    public Move move(History history, PlayerPosition position) {
        return MovePD.SILENT;
    }

}
