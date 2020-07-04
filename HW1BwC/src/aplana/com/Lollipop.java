package aplana.com;

public class Lollipop extends Candy{

    private double stiffness_coefficient;

    Lollipop(short weight, int price, double stiff_coff) throws WrongArgumentException{
        setName("\"Lollipop\"");
        setWeight(weight);
        setPrice(price);
        stiffness_coefficient = stiff_coff;
    }

    @Override
    public String toString() {
        return super.toString()
               + " stiffness coefficient=" + stiffness_coefficient + ".\n";
    }
}



