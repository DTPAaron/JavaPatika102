package homework.adventuregame;

import homework.adventuregame.locations.Location;
import homework.adventuregame.locations.SafeHouse;
import homework.adventuregame.locations.ToolStore;
import homework.adventuregame.player.Player;


import java.util.Scanner;

public class Game {
    private Scanner input =new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz ");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName= input.nextLine();
        Player player= new Player(playerName);
        System.out.println("Merhaba "+player.getName() + " Macera Adasına hoşgeldin ! ");
        player.selectChar();
        Location location=null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("--------Bölgeler-----------");
            System.out.println();
            Location[] locList={new SafeHouse(player),new ToolStore(player)};
            for (Location loc:locList) {
                System.out.println("Lokasyon id: "+loc.getId()+ "\t Lokasyon Adı : "+ loc.getName()+ "\tLokasyon Açıklama: "+loc.getLocDescr() );
            }
            System.out.println("0-Çıkış Yap");
            System.out.print("Lütfen bir bölge seçiniz : ");
            int selected=input.nextInt();
            if (selected==0){
                location=null;
            }
            else if (selected==1){
                location = new SafeHouse(player);
            }else if (selected==2){
                location = new ToolStore(player);
            }
            else{
                location = new SafeHouse(player);
            }
            if (location==null){
                System.out.println("Macera adasından ayrılıyorsunuz!!!");
                break;
            }
            if (!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }


        }

    }

}
