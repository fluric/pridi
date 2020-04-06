package prisonerdilemma;

import core.PlayerPosition;

/** Describes the player's position, including a mapping to arrays */
public enum PlayerPositionPD implements PlayerPosition {
    PLAYER_A {
        @Override
        public int index() {
            return 0;
        }
    },
    PLAYER_B {
        @Override
        public int index() {
            return 1;
        }
    };

    public abstract int index();
}
