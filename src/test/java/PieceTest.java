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
        p.setLocation(new RegularSquare(1));
        assertEquals("Regular 1",p.getLocation().getName());
    }

    @Test
    void nullConstructorShouldNotWork(){
        assertThrows(InvalidParameterException.class, () -> {
            new Piece(null);
        });
    }

    @Test
    void nullNameShouldNotWork(){
        assertThrows(InvalidParameterException.class, () -> {
            new Piece("");
        });
    }
}