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
    private static final int IDX_START_SQUARE = 0;
    private static final int IDX_JAIL_SQUARE = 10;
    private static final int IDX_TAX_SQUARE = 38;
    private static final int IDX_GO_TO_JAIL_SQUARE = 30;
    private Square[] board;

    public Board(){
        board = new Square[SIZE_BOARD];

        board[IDX_START_SQUARE] = new GoSquare();

        for(int i = 1; i < SIZE_BOARD; ++i){
            board[i] = new RegularSquare(i);
        }

        board[IDX_JAIL_SQUARE] = new JailSquare();
        board[IDX_GO_TO_JAIL_SQUARE] = new GoToJailSquare();
        board[IDX_TAX_SQUARE] = new IncomeTaxSquare();
    }

    public GoSquare getGoSquare(){
        return (GoSquare) board[0];
    }

    public JailSquare getJailSquare(){
        return (JailSquare) board[IDX_JAIL_SQUARE];
    }

    public GoToJailSquare getGoToJailSquare(){
        return (GoToJailSquare) board[IDX_GO_TO_JAIL_SQUARE];
    }

    public IncomeTaxSquare getIncomeTaxSquare(){
        return (IncomeTaxSquare) board[IDX_TAX_SQUARE];
    }

    public Square getSquare(Square oldLoc, int fvTot){
        if(oldLoc == null)
            throw new IllegalArgumentException("For input Square: oldLoc is null");
        if(fvTot < 0)
            throw new IllegalArgumentException("For input fvTot: fvTot < 0");

        int currentCase;
        String[] fullName = oldLoc.getName().split(" ");

        String oldName = fullName[0];   //square name
        String oldCase = "";            //square index
        if(fullName.length > 1)
            oldCase= fullName[1];

        switch (oldName){
            case GoSquare.NAME_OF_GO:
                currentCase = IDX_START_SQUARE;
                break;
            case JailSquare.NAME_OF_JAIL:
                currentCase = IDX_JAIL_SQUARE;
                break;
            case GoToJailSquare.NAME_OF_GOTOJAIL:
                currentCase = IDX_GO_TO_JAIL_SQUARE;
                break;
            case IncomeTaxSquare.NAME_OF_INCOMETAXSQUARE:
                currentCase = IDX_TAX_SQUARE;
                break;
            default:
                try {
                    currentCase = Integer.parseInt(oldCase);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("For input Square: oldLoc.getName() is not a name square valid");
                }
                break;
        }

        return board[(currentCase + fvTot) % SIZE_BOARD];
    }
}
