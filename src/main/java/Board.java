public class Board {

    private static final int SIZE_BOARD = 40;
    private static final String NAME_OF_START_SQUARE = "Go";
    private static final String NAME_OF_STD_SQUARE = "Square";
    private Square[] board;

    public Board(){
        board = new Square[SIZE_BOARD];

        board[0] = new Square(NAME_OF_START_SQUARE);

        for(int i = 1; i < SIZE_BOARD; ++i){
            board[i] = new Square(String.format("%s %d", NAME_OF_STD_SQUARE, i));
        }
    }

    public Square getSquare(Square oldLoc, int fvTot){
        if(oldLoc == null)
            throw new IllegalArgumentException("For input Square: oldLoc is null");
        if(fvTot < 0)
            throw new IllegalArgumentException("For input fvTot: fvTot < 0");

        int currentCase = 0;
        String oldName = oldLoc.getName();

        if(!oldName.equals(NAME_OF_START_SQUARE)) {
            String oldSubString = oldName.substring(NAME_OF_STD_SQUARE.length() + 1);
            try {
                currentCase = Integer.parseInt(oldSubString);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("For input Square: oldLoc.getName() is not a name square valid");
            }
        }

        return board[(currentCase + fvTot) % SIZE_BOARD];
    }
}
