/**
 *  _____ _____ _   _       _      ___ ______ _____ _____
 * |  __ |  ___| \ | |  _  | |    / _ \| ___ |  _  |____ |
 * | |  \| |__ |  \| | (_) | |   / /_\ | |_/ | | | |   / /
 * | | __|  __|| . ` |     | |   |  _  | ___ | | | |   \ \
 * | |_\ | |___| |\  |  _  | |___| | | | |_/ \ \_/ .___/ /
 *  \____\____/\_| \_/ (_) \_____\_| |_\____/ \___/\____/
 *
 * AUTHORS : Mattei Simon, Janssens Emmanuel, Potet Bastien
 */

public class Cup {

    private Dice[] dices;

    Cup(int numberOfDices){
        dices = new Dice[numberOfDices];
        for(int i = 0; i < dices.length; i++)
            dices[i] = new Dice();
    }

    public void roll(){
        for(Dice d : dices)
            d.roll();
    }

    public int getTotal(){
        int fvTot = 0;
        for(Dice d : dices)
            fvTot += d.getFaceValue();
        return fvTot;
    }
}
