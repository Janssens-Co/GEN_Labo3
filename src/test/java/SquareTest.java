import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testSquare()
    {
        Square s = new Square("prison");

        assertTrue(s.getName().equals("prison"));
    }
}