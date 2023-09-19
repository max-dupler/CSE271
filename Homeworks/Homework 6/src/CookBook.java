import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A CookBook class that consists of an array of Recipe objects. This class
 * provides some utility methods to aid use of this CookBook.
 * 
 * @author raodm
 *
 */
public class CookBook implements Serializable {
    /**
     * The serialization UID used for writing objects.
     */
    private static final long serialVersionUID = 5254752840087680253L;

    /**
     * The array of recipes that constitute this cook book.
     */
    Recipe[] recipes = null;

    /*-----------------------------------------------------*/
    /*  YOU CANNOT ADD ANY ADDITIONAL INSTANCE VARIABLES   */
    /*-----------------------------------------------------*/
    
    /**
     * The default constructor that merely sets the recipes array to an empty
     * array with zero elements in the recipes array.
     */
    public CookBook() {
        recipes = new Recipe[0];
    }
    
    // -------------------------------------------------------------------
    // The following methods must be implemented by students
    // -------------------------------------------------------------------

    /**
     * Load a CookBook object from a given binary file that was previously
     * created by a call to write method. If an error occurs when loading the
     * file then this method returns null. The exception generated is printed
     * with the message "Unable to load cookbook because:\n" + e.getMessage()
     * 
     * @param fileName The name of the file from where the a CookBook is to be
     *                 loaded.
     * 
     * @return Returns a newly loaded CookBook object from a given file. If an
     *         error occurs then this method displays the exception and returns
     *         null.
     */
    public static CookBook load(String fileName) {
        try {
            //initialize objectinputstream
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream(new File(fileName)));
            
            //create a new object with from the file
            Object o = input.readObject();
            
            //cast the object as a cookbook
            if (o instanceof CookBook) {
                return (CookBook) o;
            } else {
                System.out.println("This is not a cookbook");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to load cookbook because:\n" 
                    + e.getMessage());
        } catch (IOException e) {
            System.out.println("Unable to load cookbook because:\n" 
                    + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load cookbook because:\n" 
                    + e.getMessage());
        }
        // this 
        return null;
    }

    /**
     * This method can be used to write the current cook book with the current
     * set of recipes to a given file. The exception generated is printed
     * with the message "Unable to write cookbook because:\n" + e.getMessage()
     * 
     * @param fileName The file name to which this cook book must be saved.
     */
    public void write(String fileName) {
        try {
            //initialize ObjectOutputStream
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream(new File(fileName)));
            
            //write the cookbook into the file
            output.writeObject(this);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write cookbook because:\n" 
                    + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to write cookbook because:\n" 
                    + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * This method loads a recipe from a given text file and adds them to the
     * recipes array in this CookBook. The exception generated is printed
     * with the message "Unable to load recipe because:\n" + e.getMessage()
     * 
     * @param fileName The text file from where the recipe is to be loaded.
     */
    public void addRecipe(String fileName) {
        
        try {
            //create a recipe
            Recipe r = Recipe.createRecipe(fileName);
            
            //add it to the array
            addToArray(r);
            
            //print message to tell the user it the recipe has been added
            System.out.println("Recipe " + r.getName() + " added.");
        } catch (Exception e) {
            System.out.println("Unable to load recipe because:\n" 
                    + e.getMessage());
        }
    }
    
    /**.
     * helper method for addRecipe that is given a recipe object and adds it
     * to the recipe array
     * @param r a recipe to be added to the array
     */
    private void addToArray(Recipe r) {
        Recipe[] newRecipes = new Recipe[recipes.length + 1];
        System.arraycopy(recipes, 0, newRecipes, 0, recipes.length);
        newRecipes[newRecipes.length - 1] = r;
        recipes = newRecipes;
    }

    /**
     * This method searches each recipe in the recipes (instance variable) array
     * for the given String s (using the hasString method) and prints recipes
     * that have the string s.
     * 
     * @param s The string to search for.
     */
    public void showRecipes(String s) {
        //boolean to check if a recipe has been found
        boolean check = false;
        
        //check recipes and print if it contains the String s
        for (Recipe elem : recipes) {
            if (elem.hasString(s)) {
                System.out.println(elem);
                check = true;
            }
        }
        
        //print statement if no recipes are found
        if (check == false) {
            System.out.println("No matching recipes found.");
        }
    }

    /**
     * This method searches the set of recipes in this cook book to determine if
     * the given recipe exists in the cook book.
     * 
     * @param r The recipe to search for.
     * 
     * @return This method returns true if the recipe was found. Otherwise this
     *         method returns false.
     */
    public boolean hasRecipe(Recipe r) {
        //loop to go through each recipe
        for (Recipe elem : recipes) {
            
            //check if the recipe is equal to any of the recupies in the array
            if (r.equals(elem)) {
                return true;
            }
        }

        //return false if no equal recipe is found
        return false;
    }
}
