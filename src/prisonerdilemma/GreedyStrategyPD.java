package prisonerdilemma;

import core.History;
import core.Move;
import core.PlayerPosition;
import core.Strategy;

/** This strategy always chooses the selfish way to betray the opponent */
class GreedyStrategyPD implements Strategy {

    @Override
    public Move move(History history, PlayerPosition position) {
        return MovePD.BETRAYAL;
    }
}
