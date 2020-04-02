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