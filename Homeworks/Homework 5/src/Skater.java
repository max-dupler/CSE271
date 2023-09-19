
public class Skater extends Player{
    
    /**.
     * the amount of goals scored by this player
     */
    private int goals = 0;
    
    /**.
     * the amount of assists by the player
     */
    private int assists = 0;
    
    /**.
     * constructor when given name and number
     * @param name the name of the player
     * @param number the jersey number
     */
    public Skater(String name, int number) {
        super(name, number);
    }
    
    /**.
     * returns the goals this player has scored
     * @return an int type
     */
    public int getGoals() {
        return this.goals;
    }
    
    /**.
     * add a goal after a game
     */
    public void addGoal() {
        this.goals += 1;
    }
    
    /**.
     * returns the assistes this player has
     * @return an int type
     */
    public int getAssists() {
        return this.assists;
    }
    
    /**.
     * add an assist after a game
     */
    public void addAssist() {
        this.assists += 1;
    }
    
    /**.
     * returns the amount of points this player has
     * points are goals + assists
     * @return an int type
     */
    public int getPoints() {
        return this.goals + this.assists;
    }
    
    /**.
     * returns the points per game of this player
     * points per game is points divided by games played
     * @return
     */
    public double getPointsPerGame() throws ArithmeticException {
        try {
            return this.getPoints() / this.gamesPlayed;
        } catch (ArithmeticException e) {
            //return 0 if the games played is 0
            return 0;
        }
        
    }
    
    /**.
     * formats the player and their statistics when printed
     */
    public String toString() {
        return String.format("%2d %-15s %3d %3d %3d %5.2f %3d",
                this.getJerseyNum(), this.getName(), this.getGoals(),
                this.getAssists(), this.getPoints(), this.getPointsPerGame(),
                this.getPenaltyMin());
    }

}
