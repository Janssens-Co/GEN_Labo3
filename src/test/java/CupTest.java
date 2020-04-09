import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    @RepeatedTest(100)
    void totalOfCupWith2DiceShouldBeCorrect() {
        Cup cup = new Cup(2);
        cup.roll();
        assertTrue(cup.getTotal() >= 2 && cup.getTotal() <= 12);
    }

}