
public class Player {
    
    /**.
     * holds the players name
     */
    private String name;
    
    /**.
     * the jersey number of the player (1-99)
     */
    private int jerseyNum;
    
    /**.
     * the amount of games played by this player
     */
    protected int gamesPlayed = 0;
    
    /**.
     * the amount of penalty minutes a player has gotten this season
     * there are 2 penalty minutes per penalty
     */
    private int penaltyMin = 0;
    
    /**
     * Constructor when given player name
     */
    public Player(String name, int number) {
        this.name = name;
        this.jerseyNum = number;
    }
    
    /**.
     * returns the name of this player
     * @return a String
     */
    public String getName() {
        return this.name;
    }
    
    /**.
     * returns the jersey number of this player
     * @return an int type
     */
    public int getJerseyNum() {
        return this.jerseyNum;
    }
    
    /**.
     * returns the amount of games played by this player
     * @return an int type
     */
    public int getGamesPlayed() {
        return this.gamesPlayed;
    }
    
    /**.
     * gets the amount of penalty minutes for this player 
     * (2 min per penalty in hockey)
     * @return an int value
     */
    public int getPenaltyMin() {
        return this.penaltyMin;
    }
    
    /**.
     * adds two penalty minutes for each penalty
     */
    public void addPenaltyMin() {
        this.penaltyMin += 2;
    }
}
