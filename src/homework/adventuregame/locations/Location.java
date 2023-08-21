package homework.adventuregame.locations;

import homework.adventuregame.player.Player;

import java.util.Scanner;

public abstract class Location {
    private int id;
    private Player player;
    private String name;
    private String locDescr;
    public static Scanner input =new Scanner(System.in);

    public Location(int id, Player player, String name, String locDescr) {
        this.id = id;
        this.player = player;
        this.name = name;
        this.locDescr = locDescr;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocDescr() {
        return locDescr;
    }

    public void setLocDescr(String locDescr) {
        this.locDescr = locDescr;
    }
}
