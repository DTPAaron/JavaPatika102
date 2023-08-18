package homework.adventuregame.locations;

import homework.adventuregame.obstacle.Bear;
import homework.adventuregame.obstacle.Obstacle;
import homework.adventuregame.player.Player;

public class River extends BattleLoc{
    public River(Player player) {
        super(player, new Bear(),"Su", "Nehir", 5, "Ödül: Su, dikkatli ol karşına ayı çıkabilir ! ",2);
    }
}
