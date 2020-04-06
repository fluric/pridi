package prisonerdilemma;

import core.Strategy;

/** The collection of all implemented Prisoner's Dilemma strategies */
public enum StrategiesPD {
    GREEDY_PD {
        @Override
        public Strategy create() {
            return new GreedyStrategyPD();
        }
    },
    FRIENDLY_PD {
        @Override
        public Strategy create() {
            return new FriendlyStrategyPD();
        }
    },
    RESENTFUL_PD {
        @Override
        public Strategy create() {
            return new ResentfulStrategyPD();
        }

    };
    public abstract Strategy create();
}
