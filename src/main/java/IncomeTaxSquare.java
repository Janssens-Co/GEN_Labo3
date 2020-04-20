import static java.lang.Math.min;

public class IncomeTaxSquare extends Square {

    IncomeTaxSquare( )
    {
        super("IncomeTax");
    }


    @Override
    public void LandedOn(Player p)
    {
        int w  = p.getNetWorth();
        p.reduceCash((int) min(200.0,w * 10.0 / 100.0));
    }
}
