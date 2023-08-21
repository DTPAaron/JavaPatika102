package homework.adventuregame.obstacle;

import java.util.Random;

public class Snake extends Obstacle{

    public Snake() {
        super("Yılan", 2, 0,12,0);
        Random rand = new Random();
        int randomNumber = rand.nextInt(4) + 3;
        System.out.println(randomNumber);
        setDamage(randomNumber);

    }
}
