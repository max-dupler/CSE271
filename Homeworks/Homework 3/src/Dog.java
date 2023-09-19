
public class Dog extends Pet {
    /**
     * . Constructor to create a Dog given the pet constructor
     * 
     * @param kind       a String type
     * @param price      a float type
     * @param foodPerDay a float type
     */
    public Dog(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
    }

    /**
     * . returns the kind of pet
     * 
     * @return a String type
     */
    public String getKind() {
        return "Dog: " + this.kind;
    }

    /**
     * . method to help print a pet
     * 
     * @return a String type
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Dog",
                kind, price, foodPerDay);
    }

    /**
     * . returns if the type of pet is aquatic
     * 
     * @return a boolean type
     */
    public boolean isAquatic() {
        return false;
    }
}
