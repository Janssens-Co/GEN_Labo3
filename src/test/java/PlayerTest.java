import org.junit.jupiter.api.BeforeAll;
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
        assertThrows(InvalidParameterException.class,() -> { Player p = new Player(null,new Piece("cavalier"));});
    }

    @DisplayName("The player's name cannot be empty")
    @Test
    void emptyPlayerNameShouldNotWork()
    {
        assertThrows(InvalidParameterException.class,() -> { Player p = new Player("",new Piece("cavalier"));});
    }

    @DisplayName("The piece of a player cannot be null")
    @Test
    void nullPlayerPieceShouldNotWork()
    {
        assertThrows(InvalidParameterException.class,() -> { Player p = new Player("kevin'",null);});
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
        Player p = new Player("kevin",new Piece("Cavalier"));
        assertThrows(InvalidParameterException.class,() -> { p.takeTurn(dices,board);} );
    }

    @DisplayName("The dices to be rolled must not be null")
    @Test
    void nullDicesShouldNotWork()
    {
        Board board = new Board();
        Dice[] dices = null;
        Player p = new Player("kevin",new Piece("Cavalier"));

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
        Player p = new Player("kevin",new Piece("Cavalier"));

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
        Player p = new Player("kevin",new Piece("Cavalier"));

        Square oldLoc = p.piece.getLocation();
        p.takeTurn(dices,board);
        Square newLoc =  p.piece.getLocation();

        assertNotEquals(oldLoc.getName(),newLoc.getName());
    }
}