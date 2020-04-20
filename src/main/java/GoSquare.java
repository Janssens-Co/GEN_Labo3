public class GoSquare extends Square {

    public static final String NAME_OF_GO = "Go";

    GoSquare()
    {
        super(NAME_OF_GO);
    }

    @Override
    public void LandedOn(Player p)
    {
        p.addCash(200);
    }
}
