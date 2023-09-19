/**
 * . creates and stores info about worm cans
 * 
 * @author maxdupler
 *
 */
public class WormCan extends Food {

    /**
     * . constructor method when given a price and weight
     * 
     * @param price  a float type
     * @param weight a float type
     */
    public WormCan(float price, float weight) {
        super(price, weight);
    }

    /**
     * . method to get the kind of thing
     */
    public String getKind() {
        return "WormCan";
    }

    /**
     * . method to determine if the thing is aquatic
     */
    @Override
    public boolean isAquatic() {
        return true;
    }

    /**
     * . method to format the message when printing a worm can
     */
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "WormCan", price, weight);
    }

    public static void main(String[] args) {
        WormCan w1 = new WormCan((float) 10, (float) 5);
        System.out.println(w1.getKind());
        System.out.println(w1.toString());
        System.out.println(w1.isAquatic());
        System.out.println(w1.equals(w1));
    }
}
