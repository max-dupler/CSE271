/**
 * . A simple class that creates and stores things
 * 
 * @author maxdupler
 *
 */
public abstract class Thing {

    /**
     * . default constructor
     */
    public Thing() {
    }

    /**
     * . method to tell the user what type of thing they have
     * 
     * @return a String type
     */
    public abstract String getKind();

    /**
     * . method to tell the user if the thing they have is aquatic
     * 
     * @return a boolean type
     */
    public abstract boolean isAquatic();

    /**
     * . tells the user the price of their thing
     * 
     * @return a float type
     */
    public abstract float getPrice();
}
