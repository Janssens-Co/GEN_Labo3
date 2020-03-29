import java.util.Random;

public class Dice {

    private int faceValue;
    private Random random;

    Dice(){
        random = new Random();
        roll();
    }

    public void roll(){
        faceValue = random.nextInt(6) + 1;
    }

    public int getFaceValue(){
        return faceValue;
    }
}
