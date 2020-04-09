import org.junit.jupiter.api.*;

import java.security.InvalidParameterException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private String[] names = new String[]{"Kevin", "Henri", "Jean-Patrick"};
    private Piece[] pieces = new Piece[]{new Piece("Cavalier"), new Piece("Dame"), new Piece("Billet"), new Piece("Pion")};

    @BeforeEach
    void initEach()
    {
        Random r = new Random();
        player = new Player(names[r.nextInt(names.length)]);
    }

    @AfterEach
    void afterEach(){
        player = null;
    }


    @DisplayName("The player's name cannot be null")
    @Test
    void nullPlayerNameShouldNotWork()
    {
        assertThrows(InvalidParameterException.class,() -> { Player p = new Player(null); });
    }

    @DisplayName("The player's name cannot be empty")
    @Test
    void emptyPlayerNameShouldNotWork()
    {
        assertThrows(InvalidParameterException.class,() -> { Player p = new Player(""); });
    }

    @DisplayName("The initial cash is 1500")
    @Test
    void initialCashIs1500(){
        assertEquals(player.getNetWorth(), 1500);
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
        assertThrows(InvalidParameterException.class,() -> { player.takeTurn(dices,board);} );
    }

    @DisplayName("The dices to be rolled must not be null")
    @Test
    void nullDicesShouldNotWork()
    {
        Board board = new Board();
        Dice[] dices = null;

        assertThrows(InvalidParameterException.class,() -> { player.takeTurn(dices,board);} );
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

        assertThrows(InvalidParameterException.class,() -> { player.takeTurn(dices,board);} );
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

        Square oldLoc = player.piece.getLocation();
        player.takeTurn(dices,board);
        Square newLoc =  player.piece.getLocation();

        assertNotEquals(oldLoc.getName(),newLoc.getName());
    }
}