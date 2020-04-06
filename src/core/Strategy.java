package core;

public interface Strategy {
    Move move(History history, PlayerPosition position);
}
