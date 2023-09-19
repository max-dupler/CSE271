/**
 * . creates and stores info about cats
 * 
 * @author maxdupler
 *
 */
public class Cat extends Pet {

    /**
     * . Constructor to create a cat given the pet constructor
     * 
     * @param kind       a String type
     * @param price      a float type
     * @param foodPerDay a float type
     */
    public Cat(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
    }

    /**
     * . returns the kind of pet
     * 
     * @return a String type
     */
    public String getKind() {
        return "Cat: " + this.kind;
    }

    /**
     * . method to help print a pet
     * 
     * @return a String type
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Cat",
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

    public static void main(String[] args) {
        Cat c1 = new Cat("Persian", 200, 19);
        System.out.println(c1.getPrice());
        System.out.println(c1.getFoodPerDay());
        System.out.println(c1.getKind());
        System.out.println(c1);
    }

}
