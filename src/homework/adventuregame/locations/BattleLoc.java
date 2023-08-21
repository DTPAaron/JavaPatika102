package homework.adventuregame.locations;

import homework.adventuregame.inventory.armor.Heavy;
import homework.adventuregame.inventory.armor.Light;
import homework.adventuregame.inventory.armor.Medium;
import homework.adventuregame.inventory.weapon.Gun;
import homework.adventuregame.inventory.weapon.Rifle;
import homework.adventuregame.inventory.weapon.Sword;
import homework.adventuregame.obstacle.Obstacle;
import homework.adventuregame.player.Player;

import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLoc(Player player,Obstacle obstacle,String award,String name,int id,String locDescr,int maxObstacle) {
        super(id,player,name,locDescr);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber= this.randomObstacleNumber();
        System.out.println("Şuan buradasınız: "+this.getName());
        System.out.println("Dikkatli Ol! Burada "+ obsNumber+" tane "+this.getObstacle().getName()+" yaşıyor");
        System.out.print("Savaşmak için <S> , Kaçmak için <K> : ");
        String select=input.nextLine().toUpperCase();
        if (select.equals("S")){
            if (combat(obsNumber)) {
                return true;
            }
        }
        if (this.getPlayer().getHealth()<=0) {
            System.out.println("Öldünüz ! ");
            return false;
        }else {
            return true;
        }

    }
    public void afterHit(){
        System.out.println("Canınız : "+ this.getPlayer().getHealth());
        System.out.println(this.obstacle.getName()+" Canı : "+ this.getObstacle().getHealth());
        System.out.println();
    }

    public int randomObstacleNumber(){
        Random r= new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public boolean combat(int obsNumber){
        int defaultHealth=this.getObstacle().getHealth();
        for (int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(defaultHealth);
            System.out.println(i+ ". cı canavar ile savaşıyorsunuz ! ");
            playerStats();
            obstacleStats();
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.print("Vurmak için <V> , Kaçmak için <K>: ");
                String select= input.nextLine().toUpperCase();

                if (select.equals("V")){
                    Random r= new Random();
                    int chance=r.nextInt(2);
                    if (chance == 0) {
                        System.out.println("Siz vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                        afterHit();

                        if (this.getObstacle().getHealth()>0){
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage= this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage<0){
                                obstacleDamage=0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                            if (this.getPlayer().getHealth()<=0){
                                afterHit();
                                return false;
                            }
                            afterHit();
                        }

                    }else if (chance==1){
                        if (this.getObstacle().getHealth()>0){
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage= this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage<0){
                                obstacleDamage=0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                            if (this.getPlayer().getHealth()<=0){
                                afterHit();
                                return false;
                            }
                            afterHit();

                            System.out.println("Siz vurdunuz !");
                            this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }

                }else{
                    System.out.println("Kaçtınız.");
                    return true;
                }
            }
            if (this.getObstacle().getHealth()<=0){
                if(this.getName().equals("Maden")){
                    randomItem();
                }else{
                    System.out.println("Düşmanı Yendiniz !");
                    System.out.println(this.getObstacle().getAward()+ " Para kazandınız");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                    System.out.println("Güncel Paranız : " +this.getPlayer().getMoney());
                    System.out.println(this.getName()+" tüm düşmanları yendiniz");
                    System.out.println("Ödülü kazandınız : "+this.getAward());
                    if (this.getId()==3){
                        this.getPlayer().getInventory().setFood(true);
                    }else if (this.getId()==4){
                        this.getPlayer().getInventory().setFireWood(true);
                    }else if (this.getId()==5){
                        this.getPlayer().getInventory().setWater(true);
                    }
                }

            }

        }

        return true;
    }
    public void playerStats(){
        System.out.println("------------------------------------------------------");
        System.out.println("Oyuncu Değerleri");
        System.out.println("------------------------------------------------------");
        System.out.println("Silahınız: "+this.getPlayer().getInventory().getWeapon().getName()+
                "\nZırhınız : "+ this.getPlayer().getInventory().getArmor().getName()+
                "\nBloklama : "+ this.getPlayer().getInventory().getArmor().getBlock()+
                "\nHasarınız : "+this.getPlayer().getTotalDamage()+
                "\nSağlık: " +this.getPlayer().getHealth()+
                "\nPara: "+this.getPlayer().getMoney());
    }
    public void obstacleStats(){
        System.out.println("------------------------------------------------------");
        System.out.println(this.getObstacle().getName()+" Değerleri");
        System.out.println("------------------------------------------------------");
        System.out.println("Sağlık : "+this.getObstacle().getHealth()+
                           "\nHasar :"+this.getObstacle().getDamage()+
                           "\nÖdül :"+this.getObstacle().getAward());
    }
    public void randomItem(){
        Random rand = new Random();
        int randomNumber2 = rand.nextInt(100) + 1;
        System.out.println("Düşmanı Yendiniz !");
        if (randomNumber2<=15){
            int randomNumber3 = rand.nextInt(100) + 1;
            if (randomNumber3<=50){
                if (this.getPlayer().getInventory().getWeapon().getId()<1) {
                    System.out.println("Yeni bir silah kazandınız.");
                    System.out.println( "Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(new Gun());
                    System.out.println( "Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());

                }

            }else if (randomNumber3 <= 80) {
                if (this.getPlayer().getInventory().getWeapon().getId()<2) {
                    System.out.println("Yeni bir silah kazandınız.");
                    System.out.println( "Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(new Sword());
                    System.out.println( "Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }else {
                if (this.getPlayer().getInventory().getWeapon().getId()<3) {
                    System.out.println("Yeni bir silah kazandınız.");
                    System.out.println( "Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(new Rifle());
                    System.out.println( "Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }else if (randomNumber2 <= 30) {
            int randomNumber3 = rand.nextInt(100) + 1;
            if (randomNumber3<=50){
                if (this.getPlayer().getInventory().getArmor().getId()<1) {
                    System.out.println("Yeni bir kalkan kazandınız.");
                    System.out.println( "Önceki kalkanınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(new Light());
                    System.out.println( "Yeni kalkanınız: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }else if (randomNumber3 <= 80) {
                if (this.getPlayer().getInventory().getArmor().getId()<2){
                    System.out.println("Yeni bir kalkan kazandınız.");
                    System.out.println( "Önceki kalkanınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(new Medium());
                    System.out.println( "Yeni kalkanınız: " + this.getPlayer().getInventory().getArmor().getName());

                }
            }else {
                if (this.getPlayer().getInventory().getArmor().getId()<3){
                    System.out.println("Yeni bir kalkan kazandınız.");
                    System.out.println( "Önceki kalkanınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(new Heavy());
                    System.out.println( "Yeni kalkanınız: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }

        }else if (randomNumber2 <= 55) {
            int randomNumber3 = rand.nextInt(100) + 1;
            if (randomNumber3<=50){
                this.getPlayer().setMoney(this.getPlayer().getMoney()+1);
                System.out.println("Para kazandınız");
                System.out.println("Güncel Paranız : " +this.getPlayer().getMoney());

            }else if (randomNumber3 <= 80) {
                this.getPlayer().setMoney(this.getPlayer().getMoney()+5);
                System.out.println("Para kazandınız");
                System.out.println("Güncel Paranız : " +this.getPlayer().getMoney());
            }else {
                this.getPlayer().setMoney(this.getPlayer().getMoney()+10);
                System.out.println("Para kazandınız");
                System.out.println("Güncel Paranız : " +this.getPlayer().getMoney());
            }
        }else{
            System.out.println("Hiçbir şey kazanamadınız !");
        }
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

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
