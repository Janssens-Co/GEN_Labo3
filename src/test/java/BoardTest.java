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
        Square ret = board.getSquare(new RegularSquare(1), 3);
        assertEquals(new RegularSquare(4).getName(), ret.getName());
    }

    @Test
    public void GetFromSquareGo(){
        Board board = new Board();
        Square ret = board.getSquare(new GoSquare(), 3);
        assertEquals(new RegularSquare(3).getName(), ret.getName());
    }

    @Test
    public void GetFromSquareExceed(){
        Board board = new Board();
        Square ret = board.getSquare(new RegularSquare(39), 3);
        assertEquals(new RegularSquare(2).getName(), ret.getName());
    }

    @Test
    public void IllegalArgumentIfSquareIsNull(){
        Board board = new Board();

        assertThrows(IllegalArgumentException.class, () -> {
            Square ret = board.getSquare(null, 4);
        });
    }


}
