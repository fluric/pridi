package core;

public abstract class Player {
    public Strategy strategy;
    public PlayerPosition position;

    public Player(Strategy strategy) {
        this.strategy = strategy;
    }

    public Player(Strategy strategy, PlayerPosition position) {
        this.strategy = strategy;
        this.position = position;
    }

    public Strategy getStrategy() {
		return strategy;
	}

    public abstract Move move(History history);
}
