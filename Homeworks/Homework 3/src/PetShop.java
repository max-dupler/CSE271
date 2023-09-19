import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple pet store that has pets and food things.
 *
 */
public class PetShop {
    /**
     * The items available for sale in this pet shop. The items are added to
     * this list via the addItemsFromFile method.
     */
    private ArrayList<Thing> things;

    /**
     * This is an intermediate summary string that has been used to generate the
     * full summary format below. Don't use this one. Instead, use the
     * SUMMARY_FORMAT string below.
     */
    private static final String SUMMARY_SUB_FORMAT = 
            "    Number of pets      : %d%n"
            + "    Total price pets    : $%.2f%n"
            + "    Number of food items: %d%n"
            + "    Total price of food : $%.2f%n";

    /**
     * Format string to print summary of pets and food items in the pet store.
     */
    private static final String SUMMARY_FORMAT = 
            "Summary of items in Pet Shop%n"
            + "Aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT
            + "Non-aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT;

    /**
     * Format string to print food status for the pet store.
     */
    private static final String FOOD_STATUS = "Pet Shop food status:%n"
            + "    Daily aquatic food needed      : %.2f lb%n"
            + "    Daily non-aquatic food needed  : %.2f lb%n"
            + "    Aquatic food stock in store    : %.2f lb%n"
            + "    Non-aquatic food stock in store: %.2f lb%n";

    /**
     * . Keeps track of the total weight of aquatic food in stock
     */
    private float aquaticFoodWeight = 0;

    /**
     * . keeps track of the total weight of non aquatic food in stock
     */
    private float nonAquaticFoodWeight = 0;

    /**
     * Creates an empty shop without any items.
     */
    public PetShop() {
        things = new ArrayList<>();
    }

    /**
     * Returns the number of food objects in the list of things in this pet
     * store.
     * 
     * @return The number of food things currently in the list of things in this
     *         pet store.
     */
    public int getFoodCount() {
        return getAquaticFood() + getNonAquaticFood();
    }

    /**
     * . helper method for the getFoodCount method
     * 
     * @return an int type
     */
    private int getAquaticFood() {
        int numFood = 0;
        for (Thing elem : things) {
            if (elem instanceof Food && elem.isAquatic()) {
                numFood++;
                aquaticFoodWeight += ((Food) elem).getWeight();
            }
        }
        return numFood;
    }

    /**
     * . helper method for the getFoodCount method
     * 
     * @return an int type
     */
    private int getNonAquaticFood() {
        int numFood = 0;
        for (Thing elem : things) {
            if (elem instanceof Food && !elem.isAquatic()) {
                numFood++;
                nonAquaticFoodWeight += ((Food) elem).getWeight();
            }
        }
        return numFood;
    }

    /**
     * Returns the number of pet objects in the list of things in this pet
     * store.
     * 
     * @return The number of pets currently in the list of things in this pet
     *         store.
     */
    public int getPetCount() {
        return getAquaticPets() + getNonAquaticPets();
    }

    /**
     * . Helper method for getPetCount()
     * 
     * @return an int type
     */
    private int getAquaticPets() {
        int numPets = 0;
        for (Thing elem : things) {
            if (elem instanceof Pet && elem.isAquatic()) {
                numPets++;
            }
        }
        return numPets;

    }

    /**
     * . Helper method for getPetCount()
     * 
     * @return an int type
     */
    private int getNonAquaticPets() {
        int numPets = 0;
        for (Thing elem : things) {
            if (elem instanceof Pet && !elem.isAquatic()) {
                numPets++;
            }
        }
        return numPets;

    }

    /**
     * Adds items loaded from a given text file to the list of items in the
     * store. The items are stored line-by-line in the text file. Each line
     * contains values separated by a tab character. The data in the lines are
     * with: 3-columns for Food: FoodName Price Weight 4-columns for Pet :
     * PetNamme PetKind Price FoodPerDay
     * 
     * @param fileName The text file from where Things are to be added to the
     *                 list of items for sale in the pet store.
     */
    public void addItemsFromFile(String fileName) throws FileNotFoundException {
        Scanner fr = new Scanner(new File(fileName));
        while (fr.hasNext()) {
            String type = fr.next();
            switch (type) {
            case "Cat":
                Cat cat = new Cat(fr.next(), fr.nextFloat(), fr.nextFloat());
                things.add(cat);
                break;

            case "Dog":
                Dog dog = new Dog(fr.next(), fr.nextFloat(), fr.nextFloat());
                things.add(dog);
                break;

            case "Fish":
                Fish fish = new Fish(fr.next(),
                        fr.nextFloat(), fr.nextFloat());
                things.add(fish);
                break;

            default:
                addItemsFromFile1(type, fr);
                break;
            }
        }
        fr.close();
    }

    public void addItemsFromFile1(String type, Scanner fr)
            throws FileNotFoundException {
        switch (type) {
        case "Octopus":
            Octopus nextOctopus = new Octopus(fr.next(),
                    fr.nextFloat(), fr.nextFloat());
            things.add(nextOctopus);
            break;

        case "WormCan":
            WormCan nextWc = new WormCan(fr.nextFloat(), fr.nextFloat());
            things.add(nextWc);
            break;

        case "ChowBag":
            ChowBag nextCb = new ChowBag(fr.nextFloat(), fr.nextFloat());
            things.add(nextCb);
            break;

        case "Fish":
            Fish nextFish = new Fish(fr.next(),
                    fr.nextFloat(), fr.nextFloat());
            things.add(nextFish);
            break;

        default:
            break;
        }
    }

    /**
     * Interface method to print a summary of the items in the pet store. The
     * summary is computed and printed using the supplied SUMMARY_FORMAT string.
     * 
     * @see SUMMARY_FORMAT
     */
    public void printSummary() {
        System.out.printf("Summary of items in Pet Shop%n"
                + "Aquatic pets & food summary%n"
                + "    Number of pets      : %d%n"
                + "    Total price pets    : $%.2f%n"
                + "    Number of food items: %d%n"
                + "    Total price of food : $%.2f%n"
                + "Non-aquatic pets & food summary%n"
                + "    Number of pets      : %d%n"
                + "    Total price pets    : $%.2f%n"
                + "    Number of food items: %d%n"
                + "    Total price of food : $%.2f%n", getAquaticPets(),
                getAquaticPetCost(), getAquaticFood(), getAquaticFoodCost(),
                getNonAquaticPets(), getNonAquaticPetCost(),
                getNonAquaticFood(),
                getNonAquaticFoodCost());

    }

    /**
     * . returns the total cost of all of the pets
     * 
     * @return a float type
     */
    private float getTotalPetCost() {
        return getAquaticPetCost() + getNonAquaticPetCost();
    }

    /**
     * . returns the total cost of aquatic pets
     * 
     * @return a float type
     */
    private float getAquaticPetCost() {
        float price = 0;
        for (Thing elem : things) {
            if (elem instanceof Pet && elem.isAquatic()) {
                price += elem.getPrice();
            }
        }
        return price;
    }

    /**
     * . returns the total cost of non-aquatic pets
     * 
     * @return a float type
     */
    private float getNonAquaticPetCost() {
        float price = 0;
        for (Thing elem : things) {
            if (elem instanceof Pet && !elem.isAquatic()) {
                price += elem.getPrice();
            }
        }
        return price;
    }

    /**
     * . returns the total cost of the food
     * 
     * @return a float type
     */
    private float getTotalFoodCost() {
        return getAquaticFoodCost() + getNonAquaticFoodCost();
    }

    /**
     * . returns the total cost of aquatic food
     * 
     * @return a float type
     */
    private float getAquaticFoodCost() {
        float price = 0;
        for (Thing elem : things) {
            if (elem instanceof WormCan) {
                price += elem.getPrice();
            }
        }
        return price;
    }

    /**
     * . returns the total cost of aquatic food
     * 
     * @return a float type
     */
    private float getNonAquaticFoodCost() {
        float price = 0;
        for (Thing elem : things) {
            if (elem instanceof ChowBag) {
                price += elem.getPrice();
            }
        }
        return price;
    }

    /**
     * A simple method that prints all of the things in the store.
     */
    public void printAllThings() {
        printAll();
    }

    /**
     * . helper method for printAllThings
     */
    private void printAll() {
        System.out.println("List of all items:");
        for (Thing elem : things) {
            System.out.println(elem.toString());
        }
    }

    /**
     * Computes and prints the amount of aquatic and non-aquatic food needed to
     * feed all of the pets in the store along with the amount of food currently
     * available. The food needed by pets is computed by adding the daily food
     * needs of all the pets. The food available is computed by adding the
     * weight of all the food things.
     * 
     * @see FOOD_STATUS
     */
    public void reportFoodStatus() {
        getFoodStatus();
    }

    /**
     * . helper method for reportFoodStatus()
     */
    private void getFoodStatus() {
        float aquaticFood = 0;
        float nonAquaticFood = 0;
        for (Thing elem : things) {
            if (elem instanceof Pet) {
                float foodPerDay = ((Pet) elem).getFoodPerDay();
                if (elem.isAquatic()) {
                    aquaticFood += foodPerDay;
                } else {
                    nonAquaticFood += foodPerDay;
                }
            }
        }
        System.out.printf("Pet Shop food status:%n"
                + "    Daily aquatic food needed      : %.2f lb%n"
                + "    Daily non-aquatic food needed  : %.2f lb%n"
                + "    Aquatic food stock in store    : %.2f lb%n"
                + "    Non-aquatic food stock in store: %.2f lb%n",
                aquaticFood, nonAquaticFood, aquaticFoodWeight,
                nonAquaticFoodWeight);

    }
}
