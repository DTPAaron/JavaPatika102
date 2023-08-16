package homework.adventuregame.locations;

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
        }else{
            System.out.println("Marketten çıkış yapılıyor , Yine bekleriz !");
            return true;
        }
        return true;
    }

    public void printWeapon(){
        Weapon[] weaponList={new Gun(),new Sword(),new Rifle()};
        System.out.println("-------Silahlar-------");
        for (Weapon weapon:weaponList) {
            System.out.println("Id: "+weapon.getId()+ "\t Silah Adı:"+ weapon.getName()+ "\tSilah Hasarı: "+weapon.getDamage()+ "\tSilah Ücreti: "+weapon.getMoney() );
        }



    }
    public void buyWeapon(){
        Weapon[] weaponList={new Gun(),new Sword(),new Rifle()};
        System.out.print("Bir silah seçiniz : ");
        int select=input.nextInt();
        while (select<1||select> weaponList.length){
            System.out.println("Geçersiz bir değer girdiniz , Lütfen tekrar giriniz");
            select=input.nextInt();
        }
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
    public void printArmor(){

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
