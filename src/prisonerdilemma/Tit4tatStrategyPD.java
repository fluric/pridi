package prisonerdilemma;

import core.History;
import core.Move;
import core.PlayerPosition;
import core.Strategy;

/** This strategy will do the turn which the opponent has done before. It is starting with not betraying. */
class Tit4tatStrategyPD implements Strategy {

    @Override
    public Move move(History history, PlayerPosition position) {
        if (history.getPlayedRounds() == 0) {
            return MovePD.SILENT;
        } else {
            PlayerPositionPD opPos = position == PlayerPositionPD.PLAYER_A ? PlayerPositionPD.PLAYER_B : PlayerPositionPD.PLAYER_A;

            return history.getRound(history.getPlayedRounds() - 1)[opPos.index()];
        }
    }

}
