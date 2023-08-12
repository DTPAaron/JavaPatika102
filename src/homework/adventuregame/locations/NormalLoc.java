package homework.adventuregame.locations;

import homework.adventuregame.player.Player;

public abstract class NormalLoc extends Location{
    public NormalLoc(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {
        return false;
    }
}
