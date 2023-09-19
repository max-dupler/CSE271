/**
 * . Creates and stores info about food
 * 
 * @author maxdupler
 *
 */
public class Food extends Thing {
    /**
     * . stores the price of the food
     */
    public float price;

    /**
     * . stores the weight of the food
     */
    public float weight;

    /**
     * . formats the message when printing a food object
     */
    public String toStringFormat = "%s\t%s\t%.2f\t%.2f";

    /**
     * . constructor when given the price and weight
     * 
     * @param price  a float
     * @param weight a float
     */
    public Food(float price, float weight) {
        this.price = price;
        this.weight = weight;
    }

    /**
     * . gets the price of the price object
     * 
     * @return a float type
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * . gets the weight of the food object
     * 
     * @return a float type
     */
    public float getWeight() {
        return this.weight;
    }

    /**
     * . checks if a given object is the same as the pet
     * 
     * @return a boolean type
     */
    public boolean equals(Object check) {
        if (check == null) {
            return false;
        } else if (!(check instanceof Food)) {
            return false;
        }
        Food other = (Food) check;
        return (price == other.getPrice()) && (weight == other.getWeight());
    }

    @Override
    public String getKind() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAquatic() {
        return this instanceof WormCan;
    }

}
