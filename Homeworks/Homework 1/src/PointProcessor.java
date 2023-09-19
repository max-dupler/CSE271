import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is an helper class that is used to perform different operations using a
 * list of points.
 *
 */

public class PointProcessor {

    /**.
     * Read points from a given file and creates an ArrayList
     * 
     * @param fileName an input file to read points from
     * @return pointList an ArrayList of points taken from the given file
     * @throws FileNotFoundException when the file given is invalid
     */
    public static ArrayList<Point> readPointsFromFile(final String fileName)
            throws FileNotFoundException {
        ArrayList<Point> pointList = new ArrayList<Point>();
        Scanner fileReader = new Scanner(new File(fileName));
        while (fileReader.hasNext()) {
            int nextX = fileReader.nextInt();
            int nextY = fileReader.nextInt();
            Point nextPoint = new Point(nextX, nextY);
            pointList.add(nextPoint);
        }
        fileReader.close();
        return pointList;
    }

    /**.
     * Calculates the total distance by adding the absolute value of x and 
     * y of a given point
     * @param pt a given point
     * @return an int value of the calculated distance
     */
    public static int cabDistance(final Point pt) {
        return (int) (Math.abs(pt.getX())) + (int) (Math.abs(pt.getY()));
    }

    /**.
     * displays a given point
     * @param pt a point to be displayed
     */
    public static void showPoint(final Point pt) {
        System.out.printf("(%d, %d)\t%d", (int) pt.getX(), (int) pt.getY(),
                cabDistance(pt));

    }

    /**.
     * displays all points in a given ArrayList in the order they are stored
     * @param ptList an ArrayList to be displayed
     */
    public static void showAllPoints(final ArrayList<Point> ptList) {
        if (ptList.size() > 0) {
            for (int i = 0; i < ptList.size(); i++) {
                System.out.printf("[%d] ", i);
                showPoint(ptList.get(i));
                System.out.println();
            }
        } else {
            System.out.println("Empty list");
        }
    }

    /**. 
     * finds each point in a given ArrayList with the given cab distance
     * @param ptList the ArrayList to be searched
     * @param dist the cabDistance to find
     * @return sameDistance an ArrayList of each point with 
     *     the specified cabDistance
     */
    public static ArrayList<Point> findAll(final ArrayList<Point> ptList,
            int dist) {
        ArrayList<Point> sameDistance = new ArrayList<Point>();
        for (int i = 0; i < ptList.size(); i++) {
            if (cabDistance(ptList.get(i)) == dist) {
                sameDistance.add(ptList.get(i));
            }
        }
        return sameDistance;
    }
}
