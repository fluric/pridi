package core;

import java.util.List;

/** The rule interface generally defines the payoff for the players. The array position is defined by the {@link PlayerPosition} interface */
public interface Rule {

    Integer[] evaluateRound(Move[] round);

    Integer[] evaluateRounds(List<Move[]> rounds);
}
