
public class Goalie extends Player {
    
    /**.
     * saves made by the goalie
     */
    private int saves = 0;
    
    /**.
     * the amount of goals allowed by the goalie
     */
    private int goalsAllowed = 0;
    
    /**.
     * Constructor when given the name and jersey number
     * @param name the name of the goalie
     * @param number the jersey number of the goalie
     */
    public Goalie (String name, int number) {
        super(name, number);
    }
    
    /**.
     * getter method for the amount of saves for this goalie
     * @return an int value
     */
    public int getSaves() {
        return this.saves;
    }
    
    /**.
     * setter method used when adding saves 
     * @param saves an int
     */
    public void addSaves(int saves) {
        this.saves += saves;
    }
    
    /**.
     * getter method for the goals allowed by this goalie
     * @return an int value
     */
    public int getGoalsAllowed() {
        return this.goalsAllowed;
    }
    
    /**.
     * setter method used when adding goals allowed 
     * @param goals an int
     */
    public void addGoalsAllowed(int goals) {
        this.goalsAllowed += goals;
    }
    
    /**.
     * getter method for the save percentage of this goalie.
     * save percentage is calculated by dividing the amount of 
     * shots(saves + goals) by the amount of goals allowed
     * @return a double value
     */
    public double getSavePct() throws ArithmeticException {
        try {
            return (double) saves / (saves + goalsAllowed);
        } catch (ArithmeticException e) {
            //return 0 if the saves = 0
            return 0;
        }
        
    }
    
    /**.
     * getter method for the goals against average.
     * GAA is calculated by dividing the amount of 
     * goals allowed by the games played
     * @return
     */
    public double getGoalsAvg() throws ArithmeticException{
        try {
            return (double) goalsAllowed / gamesPlayed;
        } catch (ArithmeticException e) {
            //return 0 if the games played is 0
            return 0;
        }
    }
    
    /**.
     * formats the goalie and their statistics when printed
     */
    public String toString() {
        return String.format("%2d %-15s %3d %3d %5.2f %5.2f", this.getJerseyNum(),
                this.getName(), this.getSaves(), this.getGoalsAllowed(), 
                this.getSavePct(), this.getGoalsAvg());
    }
}
