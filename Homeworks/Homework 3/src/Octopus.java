/**
 * . creates and stores info about Octopus
 * 
 * @author maxdupler
 *
 */
public class Octopus extends Pet {

    /**
     * . Constructor to create am octopus given the pet constructor
     * 
     * @param kind       a String type
     * @param price      a float type
     * @param foodPerDay a float type
     */
    public Octopus(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
    }

    /**
     * . returns the kind of pet
     * 
     * @return a String type
     */
    public String getKind() {
        return "Octopus: " + this.kind;
    }

    /**
     * . method to help print a pet
     * 
     * @return a String type
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Octopus",
                kind, price, foodPerDay);
    }

    /**
     * . returns if the type of pet is aquatic
     * 
     * @return a boolean type
     */
    @Override
    public boolean isAquatic() {
        return true;
    }
}
