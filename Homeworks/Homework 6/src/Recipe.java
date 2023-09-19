import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class essentially encapsulates an array of ingredients that constitute a
 * recipe. Each recipe also has a recipe name.
 * 
 * @author raodm
 *
 */
public class Recipe implements Serializable {
    /**
     * Generated serialization UID for writing objects.
     */
    private static final long serialVersionUID = -3924945855338241570L;

    /**
     * Instance variable to hold the name of the recipe. This value is set when
     * a recipe is created from a valid recipe text file.
     */
    private String name;

    /**
     * The array of ingredients constituting a recipe. It is assumed that every
     * recipe has at least one ingredient in it. Consequently, in valid recipe
     * this array will never be null.
     */
    private Ingredient[] ingredients = new Ingredient[0];

    /*-----------------------------------------------------*/
    /* YOU CANNOT ADD ANY ADDITIONAL INSTANCE VARIABLES */
    /*-----------------------------------------------------*/

    /**
     * Getter method to obtain name of recipe.
     * 
     * @return The name of this recipe.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String s = name + "\n";
        for (Ingredient i : ingredients) {
            s += i + "\n";
        }
        return s;
    }

    // -------------------------------------------------------------------
    // The following methods must be implemented by students
    // -------------------------------------------------------------------

    /**
     * Helper method that is invoked from createRecipe method to add (at then
     * end) a new Ingredient object to the list of ingredients in this class.
     * 
     * @note It is up to you to decide how you would like to implement this
     *       relatively straightforward method.
     * 
     * @param i The ingredient to be appended to the ingredients array.
     */
    private void addIngredient(Ingredient i) {

        // create a new empty array that is one ingredient longer than
        // ingredients
        Ingredient[] newIngredients = new Ingredient[ingredients.length + 1];

        // copy the current ingredients array into the new one
        System.arraycopy(ingredients, 0, newIngredients, 0,
                ingredients.length);

        // add new ingredient to the end
        newIngredients[ingredients.length] = i;

        // set ingredients equal to the new array
        ingredients = newIngredients;
    }

    /**
     * Helper method to create a new Recipe by loading a set of ingredients from
     * a given recipe text file. The first line of the text file is assumed to
     * be the name of the recipe. Rest of the lines contains Ingredient
     * information. Use Ingredient.parseString() method to convert each line to
     * an Ingredient object and use the addIngredient() method to add the newly
     * created Ingredient to a Recipe object.
     * 
     * <p>
     * In case you are wondering, yes, you need to create a new Recipe object
     * and then set its name and add ingredients to this newly created Recipe
     * object. If all ingredients are successfully processed then return the new
     * Recipe object back to the caller.
     * </p>
     * 
     * @param fileName The text file from where the data is to be loaded.
     * 
     * @return If a Recipe is successfully loaded then this method returns a
     *         valid Recipe object.
     * 
     * @exception Exception If a Recipe could not be loaded then this method
     *                      throws an exception.
     */
    public static Recipe createRecipe(String fileName) throws Exception {
        // initialize scanner to scan the recipe file
        Scanner fr = new Scanner(new File(fileName));

        // create new recipe object
        Recipe r = new Recipe();
        r.name = fr.nextLine();

        // add ingredients
        while (fr.hasNextLine()) {
            r.addIngredient(Ingredient.parseString(fr.nextLine()));
        }

        return r; // remove this line of starter code.
    }

    // ---------------------------------------------------------------------
    // THE FOLLOWING METHODS ARE FOR PHASE #2
    // ---------------------------------------------------------------------

    /**
     * This method searches the name of the recipe and the string representation
     * of each ingredients (returned by toString method) to see if they contain
     * the String s (parameter). Use the indexOf() method to search for the
     * String s.
     * 
     * @param s The string to search for.
     * 
     * @return This method returns true if the string s was found in this
     *         Recipe.
     */
    public boolean hasString(String s) {
        return this.toString().indexOf(s) != -1;
    }

    /**
     * Two Recipe objects are equal only if: 1. Their names are equal 2. They
     * have the same ingredients in the same order
     */
    @Override
    public boolean equals(Object o) {
        //check if o is a recipe and if the names are the same 
        if (!(o instanceof Recipe)) {
            return false;
        } 
        
        //cast o as a recipe
        Recipe r = (Recipe) o;
        
        /* compare the names and the lengths of the recipes.
         * by checking if the recipes are the same length we can avoid going 
         * through a loop if it is not needed
         */
        if (!(r.getName().equals(this.getName())) 
                || r.ingredients.length != this.ingredients.length) {
            return false;
        }
        
        //check ingredients
        for (int i = 0; i < r.ingredients.length; i++) {
            if (!(r.ingredients[i].equals(this.ingredients[i]))) {
                return false;
            }
        }
        
        return true;
    }
}
