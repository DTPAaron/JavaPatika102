package homework.adventuregame.inventory;

import homework.adventuregame.inventory.armor.Armor;
import homework.adventuregame.inventory.weapon.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon=new Weapon(-1,0,0,"Yumruk") ;
        this.armor=new Armor(-1,0,0,"Yok");
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
