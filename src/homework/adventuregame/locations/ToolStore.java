package homework.adventuregame.locations;

import homework.adventuregame.inventory.armor.Armor;
import homework.adventuregame.inventory.armor.Heavy;
import homework.adventuregame.inventory.armor.Light;
import homework.adventuregame.inventory.armor.Medium;
import homework.adventuregame.inventory.weapon.Gun;
import homework.adventuregame.inventory.weapon.Rifle;
import homework.adventuregame.inventory.weapon.Sword;
import homework.adventuregame.inventory.weapon.Weapon;
import homework.adventuregame.player.Player;

public class ToolStore extends NormalLoc{
    private String name;
    private int id;
    private String locDescr;
    public ToolStore(Player player) {
        super(player);
        this.name="Mağaza";
        this.id=2;
        this.locDescr="Silah veya Zırh alabilirsiniz.";
    }

    @Override
    public boolean onLocation() {
        System.out.println("------ Mağazaya hoşgeldiniz ------");
        boolean showMenu=true;
        while (showMenu){
            System.out.println("1-Silahlar");
            System.out.println("2-Zırhlar");
            System.out.println("3- Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int select=input.nextInt();
            while (select<1||select>3){
                System.out.println("Geçersiz bir değer girdiniz , Lütfen tekrar giriniz");
                select=input.nextInt();
            }
            if (select==1){
                printWeapon();
                buyWeapon();
            }else if (select==2){
                printArmor();
                buyArmor();
            }else{
                System.out.println("Marketten çıkış yapılıyor , Yine bekleriz !");
                showMenu=false;

            }

        }
        return true;
    }

    public void printWeapon(){
        Weapon[] weaponList={new Gun(),new Sword(),new Rifle()};
        System.out.println("-------Silahlar-------");
        for (Weapon weapon:weaponList) {
            System.out.println("Id: "+weapon.getId()+ "\t Silah Adı:"+ weapon.getName()+ "\tSilah Hasarı: "+weapon.getDamage()+ "\tSilah Ücreti: "+weapon.getMoney() );
        }
        System.out.println("0-Çıkış Yap ");

    }
    public void buyWeapon(){
        Weapon[] weaponList={new Gun(),new Sword(),new Rifle()};
        System.out.print("Bir silah seçiniz : ");
        int select=input.nextInt();
        while (select<0||select> weaponList.length){
            System.out.println("Geçersiz bir değer girdiniz , Lütfen tekrar giriniz");
            select=input.nextInt();
        }
        if(select!=0){
            Weapon weapon=null;
            for (Weapon weapons:weaponList){
                if (select== weapons.getId()){
                    weapon=weapons;
                }
            }
            if (weapon.getMoney()>this.getPlayer().getMoney()){
                System.out.println(" !!!!! Paranız yetersizdir.");
            }else {
                int balance = (int) (this.getPlayer().getMoney()-weapon.getMoney());
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : "+ this.getPlayer().getMoney());
                System.out.println( "Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(weapon);
                System.out.println( "Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }

    public void printArmor(){
        Armor[] armorList={new Light(),new Medium(),new Heavy()};
        System.out.println("-------Zırhlar-------");
        for (Armor armor:armorList) {
            System.out.println("Id: "+armor.getId()+ "\t Zırh Adı:"+ armor.getName()+ "\tBloklama: "+armor.getBlock()+ "\tZırh Ücreti: "+armor.getMoney() );
        }
        System.out.println("0-Çıkış Yap ");
    }

    public void buyArmor(){
        Armor[] armorList={new Light(),new Medium(),new Heavy()};
        System.out.print("Bir kalkan seçiniz : ");
        int select=input.nextInt();
        while (select<0||select> armorList.length){
            System.out.println("Geçersiz bir değer girdiniz , Lütfen tekrar giriniz");
            select=input.nextInt();
        }
        if(select!=0){
            Armor armor=null;
            for (Armor armors:armorList){
                if (select== armors.getId()){
                    armor=armors;
                }
            }
            if (armor.getMoney()>this.getPlayer().getMoney()){
                System.out.println(" !!!!! Paranız yetersizdir.");
            }else {
                int balance = (int) (this.getPlayer().getMoney()-armor.getMoney());
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : "+ this.getPlayer().getMoney());
                System.out.println( "Önceki kalkanınız: " + this.getPlayer().getInventory().getArmor().getName());
                this.getPlayer().getInventory().setArmor(armor);
                System.out.println( "Yeni kalkanınız: " + this.getPlayer().getInventory().getArmor().getName());
            }
        }

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
