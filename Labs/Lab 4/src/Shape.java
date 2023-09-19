import java.awt.Polygon;
import java.util.Scanner;
/**
 * This class is meant to serve as the parent class (aka base class) for the
 * different shapes. The objective is to use inheritance and polymorphism to
 * streamline the code.
 *
 */
public class Shape {
    // Add any instance variables and methods here as you see fit.
    
    // Instance variable for x-position
    protected int xpos;
    // Instance variable for y-position
    protected int ypos;
    // Instance variable for height
    protected int height;
    // Instance variable for width
    protected int width;
    // String with color -- valid values are:
    // "red", "yellow", "green", and "blue"
    protected String color;
    
    //**.
     /* default constructor
      */
    public Shape () {
    }
    
    /**.
     * Constructor when given a number and scanner
     * @param num an int type
     * @param keyboard a scanner
     */
    public Shape (int num, Scanner keyboard) {
        // Create a scanner object to
        // read data from the keyboard.
        xpos = keyboard.nextInt();
        ypos = keyboard.nextInt();
        width = keyboard.nextInt();
        height = keyboard.nextInt();
        color = keyboard.next();
        // Flush out trailing new line to read numbers next
        keyboard.nextLine();
    }

    /**
     * a method to assign vertices to a given polygon
     * @return vertices a polygon
     */
    public Polygon getVertices() {
        Polygon vertices = new Polygon();
        // Add vertex in clock-wise order.
        vertices.addPoint(xpos, ypos);
        vertices.addPoint(xpos + width, ypos);
        vertices.addPoint(xpos + width, ypos + height);
        vertices.addPoint(xpos, ypos + height);
        // Return the vertices for this shape
        return vertices;
    }
    
    /**.
     * a method that returns the area of a poylgon
     * @return a double type
     */
    public double getArea() {
        return width * height;
    }
}
