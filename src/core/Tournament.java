package core;

import java.util.ArrayList;
import java.util.List;
import prisonerdilemma.PlayerPD;
import prisonerdilemma.PlayerPositionPD;
import prisonerdilemma.PrisonersDilemmaRule;
import prisonerdilemma.StrategiesPD;

public enum Tournament {
    ;

    // TODO The tournament should be more generalized and automated
    public static void main(String[] args) {
       	List<Player> players = new ArrayList<Player>();
        players.add(new PlayerPD(StrategiesPD.TIT4TAT_PD.create()));
        players.add(new PlayerPD(StrategiesPD.GREEDY_PD.create()));

        Game game = new Game(new PlayerPD(players.get(0).getStrategy(), PlayerPositionPD.PLAYER_A), 
        						new PlayerPD(players.get(1).getStrategy(), PlayerPositionPD.PLAYER_B),
        						 new PrisonersDilemmaRule(), 10);       	
        game.run();
    }
}
