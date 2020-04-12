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

public class Board {

    private static final int SIZE_BOARD = 40;
    private static final String NAME_OF_START_SQUARE = "Go";
    private Square[] board;

    public Board(){
        board = new Square[SIZE_BOARD];

        board[0] = new GoSquare();

        for(int i = 1; i < SIZE_BOARD; ++i){
            board[i] = new RegularSquare(i);
        }
    }

    public Square getSquare(Square oldLoc, int fvTot){
        if(oldLoc == null)
            throw new IllegalArgumentException("For input Square: oldLoc is null");
        if(fvTot < 0)
            throw new IllegalArgumentException("For input fvTot: fvTot < 0");

        int currentCase = 0;
        String[] fullName = oldLoc.getName().split(" ");

        String oldName = fullName[0];   //square name
        String oldCase = "";            //square index
        if(fullName.length > 1)
            oldCase= fullName[1];

        if(!oldName.equals(NAME_OF_START_SQUARE)) {

            try {
                currentCase = Integer.parseInt(oldCase);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("For input Square: oldLoc.getName() is not a name square valid");
            }
        }

        return board[(currentCase + fvTot) % SIZE_BOARD];
    }
}
