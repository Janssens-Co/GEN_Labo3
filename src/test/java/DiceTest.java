import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void newDiceShouldHaveValueBetween1and6(){
        Dice d = new Dice();
        assert(d.getFaceValue() <= 6 && d.getFaceValue() >= 1);
    }

}