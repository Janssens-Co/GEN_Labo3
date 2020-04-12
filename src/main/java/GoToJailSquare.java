public class GoToJailSquare extends Square {
    GoToJailSquare( )
    {
        super("Go to jail");
    }

    @Override
    public void LandedOn(Player p)
    {
        p.getPiece().setLocation(new JailSquare());
    }
}
