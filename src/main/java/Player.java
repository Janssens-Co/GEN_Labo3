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
    private Board board;
    private Cup cup;

    public Player(String name, Board board, Cup cup) {

        this.name = name;
        this.piece = new Piece(name + "'s piece");
        this.cash = INITIAL_CASH;
        this.board = board;
        this.cup = cup;

        if(name == null || name.equals(""))
            throw new InvalidParameterException("A player must have a name");
        if(board == null)
            throw new InvalidParameterException("There is no board to play on");
        if(cup == null)
            throw new InvalidParameterException("There are no dices");

    }

    public void takeTurn()
    {
        cup.roll();
        Square newLoc = board.getSquare(piece.getLocation(),cup.getTotal());
        piece.setLocation(newLoc);
        newLoc.LandedOn(this);

        System.out.println(toString() + " landed on " + piece.getLocation());
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    public int getNetWorth(){
        return cash;
    }

    public void addCash(int money){
        if(money < 0)
            throw new IllegalArgumentException("addCash => money : money < 0");
        cash += money;
    }

    public void reduceCash(int money){
        if(money < 0)
            throw new IllegalArgumentException("reduceCash => money : money < 0");
        cash -= money;
    }

    public Piece getPiece() { return piece; }

    public String toString(){
        return "Player " + name;
    }

}
