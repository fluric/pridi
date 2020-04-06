package prisonerdilemma;

import core.History;
import core.Move;
import core.PlayerPosition;
import core.Strategy;

/** This strategy is cooperative as long as the opponent is too. Once the opponent betrayed, it is betrayed as well */
public class ResentfulStrategyPD implements Strategy {

    @Override
    public Move move(History history, PlayerPosition position) {
        PlayerPositionPD opPos = position == PlayerPositionPD.PLAYER_A ? PlayerPositionPD.PLAYER_B : PlayerPositionPD.PLAYER_A;
        return history.getAllRounds().stream().anyMatch(i -> i[opPos.index()].equals(MovePD.BETRAYAL)) ? MovePD.BETRAYAL : MovePD.SILENT;
    }

}
