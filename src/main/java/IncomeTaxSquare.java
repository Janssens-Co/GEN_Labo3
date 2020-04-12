public class IncomeTaxSquare extends Square {

    IncomeTaxSquare( )
    {
        super("IncomeTax");
    }


    @Override
    public void LandedOn(Player p)
    {
        int w  = p.getNetWorth();
        //p.reduceCash(min(200,w*10/100));
    }
}
