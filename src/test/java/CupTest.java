import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    @Test
    void numberOfDicesInCupShouldBePositive(){
        assertThrows(IllegalArgumentException.class,() -> { new Cup(0);});
    }

    @RepeatedTest(100)
    void totalOfCupWith2DiceShouldBeCorrect() {
        Cup cup = new Cup(2);
        cup.roll();
        assertTrue(cup.getTotal() >= 2 && cup.getTotal() <= 12);
    }

}