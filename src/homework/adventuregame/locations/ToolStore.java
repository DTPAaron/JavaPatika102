package homework.adventuregame.locations;

import homework.adventuregame.player.Player;

public class ToolStore extends NormalLoc{
    private String name;
    private int id;
    private String locDescr;
    public ToolStore(Player player) {
        super(player);
        this.name="Mağaza";
        this.id=2;
        this.locDescr="Silah veya zırh alabilirsiniz.";
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz");
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

    public String getLocDescr() {
        return locDescr;
    }

    public void setLocDescr(String locDescr) {
        this.locDescr = locDescr;
    }
}
