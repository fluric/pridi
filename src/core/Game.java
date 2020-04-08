package core;

import java.util.List;

public abstract class Game {
    protected final List<Player> playerList;
    protected final Rule rule;
    protected final History history;
    // TODO Generalization to a non-deterministic number of rounds
    protected final int rounds;
    protected final boolean isPrinting;

    public Game(List<Player> playerList, Rule rule, int rounds, boolean isPrinting) {
        assert (playerList.size() == 2);
        this.playerList = playerList;
        this.rule = rule;
        this.rounds = rounds;
        this.history = new History(playerList.size());
        this.isPrinting = isPrinting;
    }

    public abstract void run();

    public Integer[] getScore() {
        return history.getScore();
    }

    public Player getPlayer(int position) {
        assert (position < playerList.size() && position >= 0);
        return playerList.get(position);
    }
}
