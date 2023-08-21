package homework.adventuregame.locations;

import homework.adventuregame.obstacle.Snake;
import homework.adventuregame.player.Player;


public class Mine extends BattleLoc{
    public Mine(Player player) {
        super(player, new Snake(), null, "Maden", 6, "Ödül: İtem, para veya hiçbir şey , dikkatli ol burada karşına zehirli yılanlar çıkabilir!!!", 5);

    }
}
