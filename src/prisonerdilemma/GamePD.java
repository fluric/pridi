package prisonerdilemma;

import java.util.List;

import core.Game;
import core.Move;
import core.Player;

public class GamePD extends Game {

    public GamePD(List<Player> playerList, PrisonersDilemmaRule rule, int rounds, boolean isPrinting) {
        super(playerList, rule, rounds, isPrinting);
        assert (playerList.size() == 2);
    }

    public void run() {
        Move a;
        Move b;
        Move[] round;
        Integer[] reward;
        for (int i = 0; i < rounds; i++) {
            a = playerList.get(PlayerPositionPD.PLAYER_A.index()).move(history);
            b = playerList.get(PlayerPositionPD.PLAYER_B.index()).move(history);
            round = new Move[] { a, b };
            reward = rule.evaluateRound(round);
            history.addRound(round, reward);
            // System.out.println("Round " + (i + 1));
            // System.out.println("Player A plays: " + a + " and Player B: " + b);
            // System.out.printf("Reward is: {%s,%s}%n", reward[0], reward[1]);
        }

        if (isPrinting)
            history.print();
    }

    public Integer[] getScore() {
        return history.getScore();
    }
}
