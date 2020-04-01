package core;

import prisonerdilemma.FriendlyPlayerPD;
import prisonerdilemma.GreedyPlayerPD;
import prisonerdilemma.ResentfulPlayerPD;

public enum Players {
    GREEDY_PD {
        @Override
        public Player create() {
            return new GreedyPlayerPD();
        }
    },
    FRIENDLY_PD {
        @Override
        public Player create() {
            return new FriendlyPlayerPD();
        }
    },
    RESENTFUL_PD {
        @Override
        public Player create() {
            return new ResentfulPlayerPD();
        }

    };
    public abstract Player create();
}
