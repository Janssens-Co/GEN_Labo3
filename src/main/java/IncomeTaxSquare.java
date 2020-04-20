import static java.lang.Math.min;

public class IncomeTaxSquare extends Square {

    public static final String NAME_OF_INCOMETAXSQUARE = "IncomeTax";

    IncomeTaxSquare( )
    {
        super(NAME_OF_INCOMETAXSQUARE);
    }


    @Override
    public void LandedOn(Player p)
    {
        int w  = p.getNetWorth();
        p.reduceCash((int) min(200.0,w * 10.0 / 100.0));
    }
}
