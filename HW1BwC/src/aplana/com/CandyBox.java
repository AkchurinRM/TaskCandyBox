package aplana.com;

public class CandyBox implements IBox{
    Candy[] candies = new Candy[100_000_000];
    int length = 0;

    private int weight = 0;
    private int price = 0;

    @Override
    public void add(Candy candy) throws WrongArgumentException {
        if (length == Integer.MAX_VALUE) throw new WrongArgumentException("No emty space in this box");

        candies[length] = candy;
        length++;

        weight += candy.getWeight();
        price += candy.getPrice();
    }

    @Override
    public void remove_by_weight(short weight) throws WrongArgumentException {

        if(weight <= 0) throw new WrongArgumentException("Wrong weight (it should be more than 0 grams)");

        int i;
        boolean flag = false;
        for (i = 0; i < length; i++) {
            if (flag = (candies[i].getWeight() == weight))
                break;
        }

        if (!flag){
            System.out.println("There are no candies with this weight");
            return;
        }

        this.weight -= candies[i].getWeight();
        price -= candies[i].getPrice();

        for (int j = i; j + 1 < length; j++){
            candies[j] = candies[j + 1];
        }

        length--;
    }

    @Override
    public void remove_by_ID(long id) throws WrongArgumentException {

        if(id < 0) throw new WrongArgumentException("Wrong id (it should be more than 0)");

        int i;
        boolean flag = false;
        for (i = 0; i < length; i++) {
            if (flag = (candies[i].getID() == id))
                break;
        }

        if (!flag){
            System.out.println("There are no candies with this id");
            return;
        }

        weight -= candies[i].getWeight();
        price -= candies[i].getPrice();

        for (int j = i; j + 1 < length; j++){
            candies[j] = candies[j + 1];
        }

        length--;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Box params:\n"
                + "weight = " + weight + ';'
                + "Price = " + price + ".\n"
        );
    }

    public void reduceWeight(double weight) throws WrongArgumentException {//думаю, что не стоит заносить в интерфейс

        if(weight <= 0) throw new WrongArgumentException("Wrong weight (it should be more than 0 grams)");

        while (this.weight >= weight && length != 0) {
            short minweight = 2001;
            for (int i = 0; i < length; i++) {
                if (candies[i].getWeight() < minweight) {
                    minweight = candies[i].getWeight();
                }
            }
            if (minweight == 2001) break; //length == 0;

            remove_by_weight(minweight);
        }
    }

    public void reducePrice(double price) throws WrongArgumentException {//думаю, что не стоит заносить в интерфейс

        if(price <= 0) throw new WrongArgumentException("Wrong price (it should be more than 0)");

        while (this.price >= price && length != 0) {
            int minprice = 10_000_001;
            long rem_id = -1;
            for (int i = 0; i < length; i++) {
                if (candies[i].getPrice() < minprice) {
                    minprice = candies[i].getPrice();
                    rem_id = candies[i].getID();
                }
            }
            if (rem_id == -1) break; //length == 0;

            remove_by_ID(rem_id);
        }
    }

    @Override
    public String toString() {
        String info = "";

        for (int i = 0; i < length; i++)
            info += candies[i].toString();

        return info;
    }
}
