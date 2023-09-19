/**
 * . A simple class that can create and modify cars
 * 
 * @author maxdupler
 *
 */
public class Car {

    /**.
     * holds the make of the car
     */
    private String make;

    /**
     * . holds the mileage of the car
     */
    private int mileage;

    /**
     * . default constructor
     */
    public Car() {
        this.make = "Unknown";
        this.mileage = 0;
    }

    /**
     * . constructor method when given a make and mileage
     * 
     * @param make    a String type
     * @param mileage an int type
     */
    public Car(String make, int mileage) {
        this.make = make;
        this.mileage = mileage;
    }

    /**
     * . constructor method when only given the make
     * 
     * @param make a String type
     */
    public Car(String make) {
        this.make = make;
        this.mileage = 0;
    }

    /**
     * . getter method to find make of the car
     * 
     * @return a String type
     */
    public String getMake() {
        return this.make;
    }

    /**
     * . getter method to find the mileage of the car
     * 
     * @return an int type
     */
    public int getMileage() {
        return this.mileage;
    }

    /**
     * . method allowing the user to drive the car
     * 
     * @param dist the distance traveled
     */
    public void drive(int dist) {
        this.mileage += Math.abs(dist);
    }

    /**
     * . method allowing the user to honk the horn of a car
     */
    public void honkHorn() {
        System.out.println(this.make + ": beep");
    }

    /**
     * . method to print and display a car
     */
    public String toString() {
        return this.make + ": " + this.mileage;
    }
}
