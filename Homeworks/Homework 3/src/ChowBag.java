/**
 * . creates and stores info about chow bags
 * 
 * @author maxdupler
 *
 */
public class ChowBag extends Food {

    /**
     * . constructor method when given a price and weight
     * 
     * @param price  a float type
     * @param weight a float type
     */
    public ChowBag(float price, float weight) {
        super(price, weight);
    }

    /**
     * . . method to get the kind of thing
     */
    public String getKind() {
        return "ChowBag";
    }

    /**
     * . . method to determine if the thing is aquatic
     */
    @Override
    public boolean isAquatic() {
        return false;
    }

    /**
     * . . method to format the message when printing a chow bag
     */
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "ChowBag", price, weight);

    }

    public static void main(String[] args) {
        ChowBag c1 = new ChowBag(20, 15);
        System.out.print(c1);
    }

}
