package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import prisonerdilemma.GamePD;
import prisonerdilemma.PlayerPD;
import prisonerdilemma.PlayerPositionPD;
import prisonerdilemma.PrisonersDilemmaRule;
import prisonerdilemma.StrategiesPD;

public enum Tournament {
    ;
    public static Map<Strategy, Integer> strategyMap;
    public static List<Game> gameList;
    public static int rounds = 10;

    // TODO The tournament should be more generalized and automated
    public static void main(String[] args) {
        loadStrategies();
        createGames();
        runTournament();
    }

    public static void loadStrategies() {
        strategyMap = new HashMap<Strategy, Integer>();
        strategyMap.put(StrategiesPD.TIT4TAT_PD.create(), 0);
        strategyMap.put(StrategiesPD.GREEDY_PD.create(), 0);
        strategyMap.put(StrategiesPD.FRIENDLY_PD.create(), 0);
        strategyMap.put(StrategiesPD.RESENTFUL_PD.create(), 0);
    }

    public static void createGames() {
        GamePD game;
        PlayerPD playerA;
        PlayerPD playerB;
        gameList = new ArrayList<Game>();

        for (Strategy strategyA : strategyMap.keySet()) {
            playerA = new PlayerPD(strategyA, PlayerPositionPD.PLAYER_A);
            for (Strategy strategyB : strategyMap.keySet()) {
                playerB = new PlayerPD(strategyB, PlayerPositionPD.PLAYER_B);
                game = new GamePD(Arrays.asList(playerA, playerB), new PrisonersDilemmaRule(), rounds, false);
                gameList.add(game);
            }
        }

    }

    public static void runTournament() {
        Strategy strategyA;
        Strategy strategyB;
        for (Game game : gameList) {
            game.run();
            strategyA = game.playerList.get(0).getStrategy();
            strategyB = game.playerList.get(1).getStrategy();
            strategyMap.replace(strategyA, strategyMap.get(strategyA) + game.getScore()[0]);
            strategyMap.replace(strategyB, strategyMap.get(strategyB) + game.getScore()[1]);

            System.out.println("Score between " + strategyA.getClass().getSimpleName() + " and " + strategyB.getClass().getSimpleName() + ":");
            System.out.println(Arrays.asList(game.history.getScore()));
        }
        for (Entry<Strategy, Integer> entry : strategyMap.entrySet()) {
            System.out.println(entry.getKey().getClass().getSimpleName() + " total score: " + entry.getValue() + " and average of "
                    + (double) entry.getValue() / rounds / strategyMap.size() / 2 + " per round");
        }

    }
}
