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

import java.security.InvalidParameterException;

public class Player {

    private int cash;
    private static final int INITIAL_CASH = 1500;
    private Piece piece;
    private String name;

    public Player(String name) {

        this.name = name;
        this.piece = new Piece(name + "'s piece");
        this.cash = INITIAL_CASH;

        if(name == null || name =="")
            throw new InvalidParameterException("A player must have a name");

    }



    public void takeTurn(Cup cup, Board board)
    {

        if(board == null)
            throw new InvalidParameterException("There is no board to play on");
        if(cup == null)
            throw new InvalidParameterException("There are no dices");

        cup.roll();
        Square newLoc = board.getSquare(piece.getLocation(),cup.getTotal());
        piece.setLocation(newLoc);

        System.out.println(toString() + " landed on " + piece.getLocation());
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() { return piece; }

    public String toString(){
        return "Player " + name;
    }

}
