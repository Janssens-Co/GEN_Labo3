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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @BeforeEach
    void initEach()
    {
        System.out.println("Init test");
    }


    @DisplayName("The player's name cannot be null")
    @Test
    void nullPlayerNameShouldNotWork()
    {
        assertThrows(InvalidParameterException.class,() -> { Player p = new Player(null);});
    }

    @DisplayName("The player's name cannot be empty")
    @Test
    void emptyPlayerNameShouldNotWork()
    {
        assertThrows(InvalidParameterException.class,() -> { Player p = new Player("");});
    }

    @DisplayName("The turn cannot be taken on a null board")
    @Test
    void nullBoardShouldNotWork()
    {
        Board board = null;
        Dice[] dices =
                {
                        new Dice(),
                        new Dice()
                };
        Player p = new Player("kevin");
        assertThrows(InvalidParameterException.class,() -> { p.takeTurn(dices,board);} );
    }

    @DisplayName("The dices to be rolled must not be null")
    @Test
    void nullDicesShouldNotWork()
    {
        Board board = new Board();
        Dice[] dices = null;
        Player p = new Player("kevin");

        assertThrows(InvalidParameterException.class,() -> { p.takeTurn(dices,board);} );
    }

    @DisplayName("One Die should not be null")
    @Test
    void nullDiceShouldNotWork()
    {
        Board board = new Board();
        Dice[] dices = {
                null,
                new Dice()
        };
        Player p = new Player("kevin");

        assertThrows(InvalidParameterException.class,() -> { p.takeTurn(dices,board);} );
    }

    @DisplayName("Player has moved from his initial Square")
    @Test
    void turnTaked()
    {
        Board board = new Board();
        Dice[] dices = {
                new Dice(),
                new Dice()
        };
        Player p = new Player("kevin");

        Square oldLoc = p.piece.getLocation();
        p.takeTurn(dices,board);
        Square newLoc =  p.piece.getLocation();

        assertNotEquals(oldLoc.getName(),newLoc.getName());
    }
}