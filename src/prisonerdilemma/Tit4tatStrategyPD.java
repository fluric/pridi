package prisonerdilemma;

import core.History;
import core.Move;
import core.PlayerPosition;
import core.Strategy;

/** This strategy is cooperative as long as the opponent is too. Once the opponent betrayed, it is betrayed as well */
class Tit4tatStrategyPD implements Strategy {

    @Override
    public Move move(History history, PlayerPosition position) {
        if (history.getPlayedRounds()==0) {
        	return MovePD.SILENT;
        }
        else {
        	PlayerPositionPD opPos = position == PlayerPositionPD.PLAYER_A ? PlayerPositionPD.PLAYER_B : PlayerPositionPD.PLAYER_A;
            System.out.println("played rounds:");
            System.out.println(history.getPlayedRounds());
            //MovePD[] opMove=history.getRound(history.getPlayedRounds());
            //return opMove[opPos.index()];
            return history.getRound(history.getPlayedRounds()-1)[opPos.index()];
    	}
    }

}
