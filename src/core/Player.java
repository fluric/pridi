package core;

public abstract class Player {
    public Strategy strategy;
    public PlayerPosition position;

    public Player(Strategy strategy, PlayerPosition position) {
        this.strategy = strategy;
        this.position = position;
    }

    public abstract Move move(History history);
}
