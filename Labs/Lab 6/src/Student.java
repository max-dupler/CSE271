import java.util.ArrayList;

/**
 * A generic student class with name and scores for the student.
 * 
 * @author raodm
 */
public abstract class Student implements Cloneable, Comparable<Student> {
    /**
     * The name of the student. Since it is final, it cannot be changed 
     * after a student object has been instantiated. Since it is a final
     * instance variable and an immutable data type, it is made public here.
     */
    public final String name;
    
    /**
     * The set of scores associated with the student.
     * 
     * @see addScore
     */
    protected ArrayList<Integer> scores;
    
    /**
     * Initializes student with given name and no scores.
     * 
     * @param name The name of the student
     */
    public Student(String name) {
        this.name = name;
        scores = new ArrayList<>();
    }
    
    /**
     * Add a score to this student.
     * 
     * @param score The score to be added. Scores must be in the range
     * 0 to 100 (inclusive).
     */
    public void addScore(int score) {
        if ((score < 0) || (score > 100)) {
            throw new IllegalArgumentException("Invalid score");
        }
        scores.add(score);
    }
    
    /**
     * Returns the average score for this student.
     * 
     * @return The average score of the student.
     */
    public int getAverageScore() {
        int sum = 0;
        for (int sc : scores) {
            sum += sc;
        }
        return (sum / scores.size());
    }
    
    /**
     * Returns a letter grade based on the average score of the student.
     * This method is relatively simple and computes letter-grades based
     * on a fixed scale, in steps of 10-points.
     * 
     * @return A letter grade ('A' through 'F') based on average scores.
     */
    public char getLetterGrade() {
        final int avg = getAverageScore();
        if (avg > 90) {
            return 'A';
        } else if (avg > 80) {
            return 'B';
        } else if (avg > 70) {
            return 'C';
        } else if (avg > 60) {
            return 'D';
        }
        return 'F';
    }
}
