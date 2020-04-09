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
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void GetASquare(){
        Board board = new Board();
        Square ret = board.getSquare(new Square("Square 1"), 3);
        assertEquals(new Square("Square 4").getName(), ret.getName());
    }

    @Test
    public void GetFromSquareGo(){
        Board board = new Board();
        Square ret = board.getSquare(new Square("Go"), 3);
        assertEquals(new Square("Square 3").getName(), ret.getName());
    }

    @Test
    public void GetFromSquareExceed(){
        Board board = new Board();
        Square ret = board.getSquare(new Square("Square 39"), 3);
        assertEquals(new Square("Square 2").getName(), ret.getName());
    }

    @Test
    public void IllegalArgumentIfSquareIsNull(){
        Board board = new Board();

        assertThrows(IllegalArgumentException.class, () -> {
            Square ret = board.getSquare(null, 4);
        });
    }

    @Test
    public void IllegalArgumentIfFvTotIsLessZero(){
        Board board = new Board();

        assertThrows(IllegalArgumentException.class, () -> {
            Square ret = board.getSquare(new Square("Square 2"), -2);
        });
    }

    @Test
    public void IllegalArgumentIfSquareIsNotValid(){
        Board board = new Board();

        assertThrows(IllegalArgumentException.class, () -> {
            Square ret = board.getSquare(new Square("Square abc"), 4);
        });
    }
}
