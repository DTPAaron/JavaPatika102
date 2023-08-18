package homework.adventuregame.locations;

import homework.adventuregame.obstacle.Obstacle;
import homework.adventuregame.player.Player;

import java.util.Random;

public abstract class BattleLoc extends Location{
    private String name;
    private int id;
    private String locDescr;
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLoc(Player player,Obstacle obstacle,String award,String name,int id,String locDescr,int maxObstacle) {
        super(player);
        this.obstacle=obstacle;
        this.award=award;
        this.name=name;
        this.id=id;
        this.locDescr=locDescr;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber= this.randomObstacleNumber();
        System.out.println("Şuan buradasınız: "+this.getName());
        System.out.println("Dikkatli Ol! Burada "+ obsNumber+" tane "+this.getObstacle().getName()+" yaşıyor");
        System.out.print("Savaşmak için <S> , Kaçmak için <K>");
        String select=input.nextLine();
        select=select.toUpperCase();
        if (select.equals("S")){

            return false;
        }else {
            return true;
        }

    }
    public int randomObstacleNumber(){
        Random r= new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
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

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
