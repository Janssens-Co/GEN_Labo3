public class GoToJailSquare extends Square {

    GoToJailSquare( )
    {
        super("GoToJail");
    }

    @Override
    public void LandedOn(Player p)
    {
        p.getPiece().setLocation(new JailSquare());
    }
}
