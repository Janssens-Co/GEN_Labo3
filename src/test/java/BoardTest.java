import org.junit.Test;

public class BoardTest {
    @Test
    public void boardShouldGetSquare(){
        Board board = new Board();
        Square oldLocation = new Square("Go");
        Square square = board.getSquare(oldLocation, 4);
        Square test = new Square("Square 3");
        assertEquals(square, test);
    }

    @Test
    public void boardShould(){

    }
}
