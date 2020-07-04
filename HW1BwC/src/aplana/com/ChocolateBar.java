package aplana.com;

public class ChocolateBar extends Candy{

    private double sweetness_ratio;

    ChocolateBar(short weight, int price, double sr) throws WrongArgumentException{
        setName("\"Chocolate\"");
        setWeight(weight);
        setPrice(price);
        sweetness_ratio = sr;
    }

    @Override
    public String toString() {
        return super.toString()
                + " sweetness ratio = " + sweetness_ratio + ".\n";
    }
}
