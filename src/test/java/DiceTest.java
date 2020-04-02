import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    private final static int MAX_VALUE_OF_DICE = 6;
    private final static int MIN_VALUE_OF_DICE = 1;

    @Test
    void newDiceShouldHaveValueBetween1and6(){
        Dice d = new Dice();
        assertTrue(d.getFaceValue() <= MAX_VALUE_OF_DICE && d.getFaceValue() >= MIN_VALUE_OF_DICE);
    }

    @Test
    void whenDiceIsRolledHisValueShouldBetween1And6(){
        Dice d = new Dice();
        d.roll();
        assertTrue(d.getFaceValue() <= MAX_VALUE_OF_DICE && d.getFaceValue() >= MIN_VALUE_OF_DICE);
        d.roll();
        assertTrue(d.getFaceValue() <= MAX_VALUE_OF_DICE && d.getFaceValue() >= MIN_VALUE_OF_DICE);
    }

}