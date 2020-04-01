package prisonerdilemma;

import core.History;
import core.Player;

public class GreedyPlayerPD implements Player{

    @Override
    public int move(History history, int position) {
        return 1;
    }

}
