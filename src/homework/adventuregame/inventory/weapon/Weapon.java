package homework.adventuregame.inventory.weapon;

public class Weapon {
    private int id;
    private int damage;
    private double money;
    private String name;

    public Weapon(int id, int damage, double money, String name) {
        this.id = id;
        this.damage = damage;
        this.money = money;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
