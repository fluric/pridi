package prisonerdilemma;

import core.History;
import core.Move;
import core.Player;
import core.Strategy;

public class PlayerPD extends Player {

    public PlayerPD(Strategy strategy, PlayerPositionPD position) {
        super(strategy, position);
    }

    @Override
    public Move move(History history) {
        return strategy.move(history, position);
    }

}
