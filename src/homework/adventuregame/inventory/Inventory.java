package homework.adventuregame.inventory;

import homework.adventuregame.inventory.armor.Armor;
import homework.adventuregame.inventory.weapon.Weapon;

import java.lang.reflect.Array;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean water,food,fireWood;

    public Inventory() {
        this.weapon=new Weapon(-1,0,0,"Yumruk") ;
        this.armor=new Armor(-1,0,0,"Paçavra");
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

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFireWood() {
        return fireWood;
    }

    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }
}
