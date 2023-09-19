/**.
 * creates and stores info about fish
 * 
 * @author maxdupler
 *
 */
public class Fish extends Pet {

    /**
     * . Constructor to create a fish given the pet constructor
     * 
     * @param kind       a String type
     * @param price      a float type
     * @param foodPerDay a float type
     */
    public Fish(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
    }

    /**
     * . returns the kind of pet
     * 
     * @return a String type
     */
    public String getKind() {
        return "Fish: " + this.kind;
    }

    /**
     * . method to help print a pet
     * 
     * @return a String type
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Fish",
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

    public static void main(String[] args) {
        Fish f1 = new Fish("Goldfish", 10, 5);
        Fish f2 = new Fish("Goldfish", 10, 5);
        System.out.println(f1);
        System.out.println(f1.getFoodPerDay());
        System.out.println(f1.getPrice());
        System.out.println(f1.getKind());
        System.out.println(f1.equals(f2));

    }

}
