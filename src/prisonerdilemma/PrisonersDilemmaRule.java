package prisonerdilemma;

import java.util.List;

import core.Move;
import core.Rule;

/** https://en.wikipedia.org/wiki/Prisoner%27s_dilemma */
public class PrisonersDilemmaRule implements Rule {
    @Override
    public Integer[] evaluateRound(Move[] round) {
        if (round[0] == MovePD.SILENT && round[1] == MovePD.SILENT)
            return new Integer[] { -1, -1 };
        else if (round[0] == MovePD.SILENT && round[1] == MovePD.BETRAYAL)
            return new Integer[] { -3, 0 };
        else if (round[0] == MovePD.BETRAYAL && round[1] == MovePD.SILENT)
            return new Integer[] { 0, -3 };
        else
            return new Integer[] { -2, -2 };
    }

    @Override
    public Integer[] evaluateRounds(List<Move[]> rounds) {
        Integer[] totalReward = new Integer[] { 0, 0 };
        Integer[] reward;
        for (Move[] round : rounds) {
            reward = evaluateRound(round);
            totalReward[0] += reward[0];
            totalReward[1] += reward[1];
        }
        return totalReward;
    }

}
