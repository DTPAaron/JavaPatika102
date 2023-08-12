package homework.adventuregame.locations;

import homework.adventuregame.player.Player;

public class SafeHouse extends NormalLoc{
    private String name;
    private int id;
    private String locDescr;
    public SafeHouse(Player player) {
        super(player);
        this.id=1;
        this.name="Güvenli Ev";
        this.locDescr="Burası sizin için güvenli bir ev , düşman yoktur.";
    }
    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz");
        System.out.println("Canınız yenilendi");
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getLocDescr() {
        return locDescr;
    }
    @Override
    public void setLocDescr(String locDescr) {
        this.locDescr = locDescr;
    }
}
