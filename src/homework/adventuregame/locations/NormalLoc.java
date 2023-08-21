package homework.adventuregame.locations;

import homework.adventuregame.player.Player;

public abstract class NormalLoc extends Location{
    public NormalLoc(int id, Player player, String name, String locDescr) {
        super(id, player, name, locDescr);
    }

    @Override
    public boolean onLocation() {
        return false;
    }
}
