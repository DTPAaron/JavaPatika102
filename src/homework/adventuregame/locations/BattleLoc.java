package homework.adventuregame.locations;

import homework.adventuregame.player.Player;

public abstract class BattleLoc extends Location{
    public BattleLoc(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {
        return false;
    }

}
