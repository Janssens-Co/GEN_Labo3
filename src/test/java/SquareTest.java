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

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testNameEquals()
    {
        Square s = new Square("prison");

        assertTrue(s.getName().equals("prison"));
    }

    @Test
    void nullConstructorShouldNotWork()
    {
        assertThrows(InvalidParameterException.class, () -> {new Square(null);});
    }
    @Test
    void emptyConstructorShouldNotWork()
    {
        assertThrows(InvalidParameterException.class, () -> {new Square("");});
    }
}