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

    Piece piece;

    public int getNetWorth() {
        return cash;
    }

    public String getName() {
        return name;
    }

    private String name;


    public Player(String name) {

        this.name = name;
        this.piece = new Piece(name + "'s piece");
        this.cash = INITIAL_CASH;

        if(name == null || name =="")
            throw new InvalidParameterException("A player must have a name");

        if(piece == null)
            throw new InvalidParameterException("Piece must be present");
    }



    public void takeTurn(Dice []dices, Board board)
    {

        if(board == null)
            throw new InvalidParameterException("There is no board to play on");
        if(dices == null)
            throw new InvalidParameterException("There are no dices");

        int fv;
        int fvTot = 0;

        Square oldLoc;
        Square newLoc;

        oldLoc = piece.getLocation();
        for(int i = 0; i < 2; i++)
        {
            if(dices[i]==null)
                throw new InvalidParameterException("Dice " + i + " is null");

            dices[i].roll();
            fv = dices[i].getFaceValue();
            fvTot += fv;
        }

        newLoc = board.getSquare(oldLoc,fvTot);
        piece.setLocation(newLoc);

        System.out.println(toString() + " landed on " + piece.getLocation());
    }

    public String toString(){
        return "Player " + name;
    }

}
