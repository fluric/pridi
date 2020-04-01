package core;

import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.Tensors;

public class Game {
    private final Player playerA;
    private final Player playerB;
    private final Rule rule;
    private final Tensor rewardHistory = Tensors.empty();
    private final int rounds;
    // ---
    private final History history = new History();

    public Game(Player playerA, Player playerB, Rule rule, int rounds) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.rule = rule;
        this.rounds = rounds;
    }

    public void run() {
        int a;
        int b;
        Tensor reward;
        Tensor move;
        for (int i = 0; i < rounds; i++) {
            a = playerA.move(history, 0);
            b = playerB.move(history, 1);
            move = Tensors.vector(a, b);
            reward = rule.evaluate(move);
            rewardHistory.append(reward);
            System.out.println("Round " + i + 1);
            System.out.println("Player A plays: " + a + " and Player B: " + b);
            System.out.println("Payoff is: " + reward.toString());
            history.addMove(move);
        }
        System.out.println("The move history is:");
        System.out.println(history.getAllMoves());

        System.out.println("The reward history is:");
        System.out.println(rewardHistory);

        System.out.println("Total reward is:");
        System.out.println(rule.evaluateMoves(history.getAllMoves()));

    }

    public void evalute() {
    }
}
