package core;

import prisonerdilemma.PlayerPD;
import prisonerdilemma.PlayerPositionPD;
import prisonerdilemma.PrisonersDilemmaRule;
import prisonerdilemma.StrategiesPD;

public enum Tournament {
    ;

    // TODO The tournament should be more generalized and automated
    public static void main(String[] args) {
        Player playerA = new PlayerPD(StrategiesPD.RESENTFUL_PD.create(), PlayerPositionPD.PLAYER_A);
        Player playerB = new PlayerPD(StrategiesPD.GREEDY_PD.create(), PlayerPositionPD.PLAYER_B);
        Game game = new Game(playerA, playerB, new PrisonersDilemmaRule(), 10);
        game.run();
    }
}
