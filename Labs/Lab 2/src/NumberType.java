import java.util.Scanner;

/**
 * . A java program to determine if a number is an int, double or string
 * 
 * @author maxdupler
 *
 */

public class NumberType {

    /**
     * . Main method that reads an input from the user and tries to parse it as
     * an int or double.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // initiate scanner and get word/num from user
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word or number: ");
        String s = in.next();
        String type = "String";
        // try to parse as an int
        try {
            Integer.parseInt(s);
            type = "int";
        } catch (NumberFormatException nfe) {
        }
        // if not an int, try to parse as a double
        if (!(type.equals("int"))) {
            try {
                Double.parseDouble(s);
                type = "double";
            } catch (NumberFormatException nfe) {
            }
        }
        in.close();
        System.out.println(s + " is a " + type);
    }

}
