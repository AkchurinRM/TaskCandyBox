package aplana.com;

public abstract class Candy{
    private static long last_added_id = -1;

    private long ID;
    private String name;
    private short weight;
    private int price;

    public Candy(){
        last_added_id++;
        ID = last_added_id;
    }

    protected void setName(String name){
        this.name = name;
    }

    protected void setWeight(short weight) throws WrongArgumentException {
        if(weight <= 0 || weight > 2000) throw new WrongArgumentException("Wrong weight (it should be in range (0,2000] in grams)");
        this.weight = weight;
    }

    public short getWeight() {
        return weight;
    }

    protected void setPrice(int price) throws WrongArgumentException {
        if(price <= 0 || price > 10_000_000) throw new WrongArgumentException("Wrong price (it should be in range (0, 10_000_000] in euro)");
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public long getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Name = " + name + ';'
               + " ID =" + ID + ';'
               + " weight = " + weight + ';'
               + " price = " + price + ';';
    }
}
