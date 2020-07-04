package aplana.com;

public class Marmalade extends Candy{

    private double softness_factor;

    Marmalade(short weight, int price, double sf) throws WrongArgumentException{
        setName("\"Marmalade\"");
        setWeight(weight);
        setPrice(price);
        softness_factor = sf;
    }

    @Override
    public String toString() {
        return super.toString()
                + " softness factor = " + softness_factor + ".\n";
    }
}

