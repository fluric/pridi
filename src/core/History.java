package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This class should contain all accessible information for the player to choose its next move */
public class History implements Serializable {
    private final List<Move[]> rounds;
    private final List<Integer[]> rewards;
    private final Integer[] score;
    private final int playerNumber;

    public History(int playerNumber) {
        this.rounds = new ArrayList<Move[]>();
        this.rewards = new ArrayList<Integer[]>();
        this.score = new Integer[playerNumber];
        Arrays.fill(this.score, 0);
        this.playerNumber = playerNumber;
    }

    public List<Move[]> getAllRounds() {
        return rounds;
    }

    public Move[] getRound(int round) {
        assert (rounds.size() > round);
        return rounds.get(round);
    }

    public Integer[] getReward(int round) {
        assert (rewards.size() > round);
        return rewards.get(round);
    }

    public Integer[] getScore() {
        return score;
    }

    public int getPlayedRounds() {
        return rounds.size();
    }

    public void addRound(Move[] round, Integer[] reward) {
        assert (round.length == playerNumber);
        assert (reward.length == playerNumber);
        rounds.add(round);
        rewards.add(reward);

        // update score
        for (int player = 0; player < playerNumber; player++) {
            score[player] += reward[player];
        }
    }

    public void print() {
        System.out.println("The move history is:");
        rounds.forEach(i -> System.out.println(Arrays.toString(i)));

        System.out.println("The reward history is:");
        rewards.forEach(i -> System.out.println(Arrays.toString(i)));

        System.out.println("Total reward is:");
        System.out.printf(Arrays.toString(score));
    }
}
