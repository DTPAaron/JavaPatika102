package homework.adventuregame.locations;


import homework.adventuregame.obstacle.Zombie;
import homework.adventuregame.player.Player;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player,new Zombie(),"Yemek","Mağara",3,"Ödül: Yemek, dikkatli ol karşına zombi çıkabilir !",3);
    }
}
