package core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Player playerA;
    private final Player playerB;
    private final Rule rule;
    private final List<Integer[]> rewardHistory = new ArrayList<>();
    private final int rounds;
    // ---
    private final History history = new History();

    // TODO Should be generalized, e.g., it could contain more than two players and a non-deterministic number of rounds
    public Game(Player playerA, Player playerB, Rule rule, int rounds) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.rule = rule;
        this.rounds = rounds;
    }

    // TODO This function should be generalized, i.e. it should return the total reward for {@link Tournament}
    public void run() {
        Move a;
        Move b;
        Move[] moves;
        Integer[] reward;
        for (int i = 0; i < rounds; i++) {
            a = playerA.move(history);
            b = playerB.move(history);
            moves = new Move[] { a, b };
            reward = rule.evaluateRound(moves);
            rewardHistory.add(reward);
            System.out.println("Round " + (i + 1));
            System.out.println("Player A plays: " + a + " and Player B: " + b);
            System.out.printf("Reward is: {%s,%s}%n", reward[0], reward[1]);
            history.addRound(moves);
        }
        System.out.println("The move history is:");
        history.getAllRounds().forEach(i -> System.out.printf("{%s,%s}%n", i[0], i[1]));

        System.out.println("The reward history is:");
        rewardHistory.forEach(i -> System.out.printf("{%s,%s}%n", i[0], i[1]));

        System.out.println("Total reward is:");
        Integer[] totalRewards = rule.evaluateRounds(history.getAllRounds());
        System.out.printf("{%s,%s}%n", totalRewards[0], totalRewards[1]);

    }
}
