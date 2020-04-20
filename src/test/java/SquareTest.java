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

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testNameEquals()
    {
        Square s = new GoSquare();
        assertTrue(s.getName().equals("Go"));

        Square s2 = new GoToJailSquare();
        assertTrue(s2.getName().equals("GoToJail"));

        Square s3 =  new IncomeTaxSquare();
        assertTrue((s3.getName().equals("IncomeTax")));

        Square s4 = new RegularSquare(2);
        assertTrue(s4.getName().equals("Regular 2"));
    }

    static int repeat = 1;
    @RepeatedTest(40)
    void testSquareCreate()
    {
        Square s = new RegularSquare(repeat);
        assertTrue(s.getName().equals(String.format("Regular %d",repeat)));
        repeat++;
    }
    /*@Test
    void nullConstructorShouldNotWork()
    {
        assertThrows(InvalidParameterException.class, () -> {new GoSquare(null);});
    }
    @Test
    void emptyConstructorShouldNotWork()
    {
        assertThrows(InvalidParameterException.class, () -> {new Square("");});
    }*/
}