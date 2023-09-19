/**
 * . creates and stores pets
 * 
 * @author maxdupler
 *
 */
public class Pet extends Thing {

    /**
     * . stores the kind of pet
     */
    protected String kind;

    /**
     * . stores the price of the pet
     */
    protected float price;

    /**
     * . stores the food per day needed for the pet
     */
    protected float foodPerDay;

    /**
     * . formats the message when printing a pet
     */
    public String toStringFormat = "%s\t%s\t%.2f\t%.2f";

    /**
     * . constructor method used when given a type of pet, the price and food
     * per day
     * 
     * @param kind       a String
     * @param price      a float
     * @param foodPerDay a float
     */
    public Pet(String kind, float price, float foodPerDay) {
        this.kind = kind;
        this.price = price;
        this.foodPerDay = foodPerDay;
    }

    /**
     * . gets the price of a pet
     * 
     * @return a float type
     */
    @Override
    public float getPrice() {
        return this.price;
    }

    /**
     * . gets the food required per day for a pet
     * 
     * @return a float type
     */
    public float getFoodPerDay() {
        return this.foodPerDay;
    }

    /**
     * . checks if a given object is the same as the pet
     * 
     * @return a boolean type
     */
    public boolean equals(Object check) {
        if (check == null) {
            return false;
        }
        if (!(check instanceof Pet)) {
            return false;
        }
        Pet other = (Pet) check;
        return kind.equals(other.kind);
    }

    @Override
    public String getKind() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAquatic() {
        return kind.equals("Octopus") || kind.equals("Fish");
    }
}
