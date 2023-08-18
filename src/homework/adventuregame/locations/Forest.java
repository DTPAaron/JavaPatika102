package homework.adventuregame.locations;


import homework.adventuregame.obstacle.Vampire;
import homework.adventuregame.player.Player;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player,new Vampire(),"Odun","Orman",4,"Ödül: Odun, dikkatli ol karşına vampir çıkabilir !",3);
    }
}
