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

import org.junit.jupiter.api.*;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    private Player player;

    @BeforeEach
    void initEach(){
        Board board = new Board();
        Cup cup = new Cup(2);
        player = new Player("Bastien", board, cup);
    }

    @AfterEach
    void afterEach(){
        player = null;
    }

    @Test
    void testNameEquals()
    {
        Square s = new GoSquare();
        Square s2 = new GoToJailSquare();
        Square s3 =  new IncomeTaxSquare();
        Square s4 = new RegularSquare(2);

        assertAll(
                () -> assertEquals("Go", s.getName()),
                () -> assertEquals("GoToJail", s2.getName()),
                () -> assertEquals("IncomeTax", s3.getName()),
                () -> assertEquals("Regular 2", s4.getName())
        );
    }

    static int repeat = 1;
    @RepeatedTest(40)
    void testSquareCreate()
    {
        Square s = new RegularSquare(repeat);
        assertEquals(s.getName(), String.format("Regular %d", repeat));
        repeat++;
    }

    @DisplayName("When landed on IncomeTax Square -> reduceCash of 10% of cash")
    @Test
    void shouldReduce10Percent()
    {
        IncomeTaxSquare taxSquare = new IncomeTaxSquare();
        taxSquare.LandedOn(player);
        assertEquals(player.getNetWorth(), 1500 - (10 / 100.0 * 1500));
    }

    @DisplayName("When landed on IncomeTax Square -> reduceCash of 200")
    @Test
    void shouldReduce200()
    {
        IncomeTaxSquare taxSquare = new IncomeTaxSquare();
        player.addCash(8000);
        taxSquare.LandedOn(player);
        assertEquals(player.getNetWorth(), 9500 - 200);
    }

    @DisplayName("When landed on Go to jail square -> player should be on Jail square")
    @Test
    void playerShouldBeOnJailSquare()
    {
        GoToJailSquare goToJailSquare = new GoToJailSquare();
        goToJailSquare.LandedOn(player);
        assertEquals(player.getPiece().getLocation(), player.getBoard().getJailSquare());
    }

    @DisplayName("When landed on Go Square -> addCash of 200")
    @Test
    void shouldAdd200()
    {
        GoSquare goSquare = new GoSquare();
        goSquare.LandedOn(player);
        assertEquals(player.getNetWorth(), 1700);
    }
}