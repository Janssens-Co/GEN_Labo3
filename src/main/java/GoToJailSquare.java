public class GoToJailSquare extends Square {

    public final static String NAME_OF_GOTOJAIL = "GoToJail";

    public GoToJailSquare( )
    {
        super(NAME_OF_GOTOJAIL);
    }

    @Override
    public void LandedOn(Player p)
    {
        p.getPiece().setLocation(p.getBoard().getJailSquare());
    }
}
