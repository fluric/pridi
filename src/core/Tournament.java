package core;

import prisonerdilemma.PrisonersDilemmaRule;

public enum Tournament {
    ;
    
    public static void main(String[] args) {
        Game game = new Game(Players.FRIENDLY_PD.create(), Players.RESENTFUL_PD.create(), new PrisonersDilemmaRule(), 10);
        game.run();
    }
}
