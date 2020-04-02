import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {


    @Test
    void nameOfPieceShouldBeCorrectWhenBuilt() {
        Piece p = new Piece("Pion");
        assertEquals("Pion",p.getName());
    }

    @Test
    void newPieceShouldBeOnGoSquare() {
        Piece p = new Piece("Test");
        assertEquals("Go",p.getLocation().getName());
    }

    @Test
    void newLocationShouldBeCorrect() {
        Piece p = new Piece("Go");
        p.setLocation(new Square("Square 1"));
        assertEquals("Square 1",p.getLocation().getName());
    }
}