package homework.adventuregame.inventory;

import homework.adventuregame.inventory.weapon.Weapon;

public class Inventory {
    private Weapon weapon;

    public Inventory() {
        this.weapon=new Weapon(0,0,0,"Yumruk") ;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
