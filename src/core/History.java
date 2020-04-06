package core;

import java.util.ArrayList;
import java.util.List;

/** This class should contain all accessible information for the player to choose its next move */
public class History {
    private List<Move[]> rounds;

    public History() {
        this(new ArrayList<Move[]>());
    }

    public History(List<Move[]> rounds) {
        this.rounds = rounds;
    }

    public List<Move[]> getAllRounds() {
        return rounds;
    }

    public Move[] getRound(int round) {
        assert (rounds.size() > round);
        return rounds.get(round);
    }

    public int getPlayedRounds() {
        return rounds.size();
    }

    public void addRound(Move[] round) {
        assert (rounds.size() == 0 || rounds.get(0).length == round.length);
        rounds.add(round);
    }
}
