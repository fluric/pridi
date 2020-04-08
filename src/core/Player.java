package core;

public abstract class Player {
    protected Strategy strategy;
    protected PlayerPosition position;

    public Player(Strategy strategy, PlayerPosition position) {
        this.strategy = strategy;
        this.position = position;
    }

    public abstract Move move(History history);

    public Strategy getStrategy() {
        return strategy;
    }
}
