package aplana.com;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random rnd = new Random();

    /**
     * Method shows all information about the box and candies in it
     * @param cbox
     */
    public static void writeBoxInfo(CandyBox cbox){
        System.out.println("Candies in the box:");
        System.out.println(cbox.toString() + "\n");

        System.out.println("Box Info:");
        cbox.showInfo();
    }

    /**
     * Method adds random candy w random params into the box
     * @param cbox
     * @throws WrongArgumentException
     */
    public static void addRandomCandy(CandyBox cbox) throws WrongArgumentException {
        Candy some_candy;
        switch (rnd.nextInt(3)) {
            case 0: {
                some_candy = new Lollipop((short)(rnd.nextInt(2000) + 1), rnd.nextInt(10_000_000) + 1, rnd.nextDouble() * 1000);
                break;
            }
            case 1: {
                some_candy = new Marmalade((short)(rnd.nextInt(2000) + 1), rnd.nextInt(10_000_000) + 1, rnd.nextDouble() * 5000);
                break;
            }
            default: {
                some_candy = new ChocolateBar((short)(rnd.nextInt(2000) + 1), rnd.nextInt(10_000_000) + 1, rnd.nextDouble() * 10_000);
                break;
            }
        }
        cbox.add(some_candy);
    }

    /**
     * Method removes first candy w same weight as given weight
     * @param cbox
     * @throws WrongArgumentException
     */
    public static void removeCandyByWeight(CandyBox cbox, Scanner in) {
        System.out.println("Input some candies weight (to delete it from box)");

        boolean flag = false;
        while (!flag){
            try {
                flag = true;
                short weight = (short) in.nextInt();
                cbox.remove_by_weight(weight);
            } catch (WrongArgumentException ex) {
                flag = false;
                System.out.println(ex.getMessage());
            } catch (NoSuchElementException ex) {
                flag = false;
                System.out.println("Wrong weight");
            }
            in.nextLine();

            if (!flag) System.out.println("Wrong input, retry");
        }

        writeBoxInfo(cbox);
    }

    /**
     * Method removes first candy w same ID as given weight
     * @param cbox
     * @throws WrongArgumentException
     */
    public static void removeCandyByID(CandyBox cbox, Scanner in) {
        System.out.println("Input some candies ID (to delete it from box)");

        boolean flag = false;
        while (!flag) {
            try {
                flag = true;
                long ID = in.nextLong();
                cbox.remove_by_ID(ID);
            } catch (WrongArgumentException ex) {
                flag = false;
                System.out.println(ex.getMessage());
            } catch (NoSuchElementException ex) {
                flag = false;
                System.out.println("Wrong ID");
            }
            in.nextLine();

            if (!flag) System.out.println("Wrong input, retry");
        }

        writeBoxInfo(cbox);
    }

    /**
     * Method redux box by removing candies w lowest weight (until boxes weight != given max weight)
     * @param cbox
     * @throws WrongArgumentException
     */
    public static void reduxBoxByWeight(CandyBox cbox, Scanner in) {
        System.out.println("Input some candies weight (to reduce boxes weight)");

        boolean flag = false;
        while (!flag) {
            try {
                flag = true;
                short weight = (short) in.nextInt();
                cbox.reduceWeight(weight);
            } catch (WrongArgumentException ex) {
                flag = false;
                System.out.println(ex.getMessage());
            } catch (NoSuchElementException ex) {
                flag = false;
                System.out.println("Wrong weight");
            }
            in.nextLine();

            if (!flag) System.out.println("Wrong input, retry");
        }

        writeBoxInfo(cbox);
    }

    /**
     * Method redux box by removing candies w lowest price (until boxes price != given max price)
     * @param cbox
     * @throws WrongArgumentException
     */
    public static void reduxBoxByPrice(CandyBox cbox, Scanner in) {
        System.out.println("Input some candies price (to reduce boxes price)");

        boolean flag = false;
        while (!flag) {
            try {
                flag = true;
                int price = in.nextInt();
                cbox.reducePrice(price);
            } catch (WrongArgumentException ex) {
                flag = false;
                System.out.println(ex.getMessage());
            } catch (NoSuchElementException ex) {
                flag = false;
                System.out.println("Wrong price");
            }
            in.nextLine();

            if (!flag) System.out.println("Wrong input, retry");
        }

        writeBoxInfo(cbox);
    }

    public static void main(String[] args){
        String cmd;
        Scanner in = new Scanner(System.in);
        do{
            cmd = "";

            System.out.println("Enter amount of candies in the box in range [1,1000]");

            int n = 1;
            try {
                while ((n = in.nextInt()) > 1000 || n < 1) { //логичные ограничения
                    System.out.println("Wrong input");
                }
            } catch (NoSuchElementException ex){
                System.out.println("Not integer input");
                in.nextLine();
                continue;
            }

            // Заполнение коробки

            CandyBox cbox = new CandyBox();
            //n = rnd.nextInt(101); // - можно сделать рандом
            for (int i = 0; i < n; i++) {
                try {
                    addRandomCandy(cbox);
                } catch (WrongArgumentException ex) {
                    i--;
                    //System.out.println(ex.getMessage()); // to find the problem
                }
            }

            writeBoxInfo(cbox);

            System.out.println("\nThat is all info\n");

            removeCandyByWeight(cbox, in);

            removeCandyByID(cbox, in);

            reduxBoxByWeight(cbox, in);

            reduxBoxByPrice(cbox, in);

            System.out.println("\nTo leave the program type \"exit\", to do more searches press *enter*");
            cmd = in.nextLine();
        }
        while (!((cmd.toLowerCase()).equals("exit")));
    }
}
