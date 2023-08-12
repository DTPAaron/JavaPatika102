package homework.adventuregame.player;

import homework.adventuregame.locations.Location;
import homework.adventuregame.locations.SafeHouse;
import homework.adventuregame.locations.ToolStore;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner input =new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void selectChar(){
        GameChar[] charlist= {new Samurai(),new Archer(),new Knight()};
        System.out.println("Karaktlerler ");
        for (GameChar gamechar :charlist) {
            System.out.println("Id: "+gamechar.getId()+
                    "\t Karakter: "+gamechar.getName() +
                    "\t Hasar: "+gamechar.getDamage() +
                    "\t Sağlık: " +gamechar.getHealth() +
                    "\t Para: "+getMoney());
        }
        System.out.print("Lütfen bir karakter seçiniz : ");
        int selectchar= input.nextInt();
        if (selectchar==1){
            initPlayer(new Samurai());
        }else if (selectchar==2){
            initPlayer(new Knight());
        }else if (selectchar==3){
            initPlayer(new Archer());
        }else {
            initPlayer(new Samurai());
        }
        System.out.println(" Karakter: "+this.getCharName()+
                ", Hasar: "+this.getDamage()+
                ", Sağlık: " +this.getHealth()+
                ", Para: "+this.getMoney());

    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

}
