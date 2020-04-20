public class GoToJailSquare extends Square {

    public GoToJailSquare( )
    {
        super("GoToJail");
    }

    @Override
    public void LandedOn(Player p)
    {
        p.getPiece().setLocation(new JailSquare());
    }
}
