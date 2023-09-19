import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**.
 * Tracks a team and it's statistics throughout a season
 * 
 * @author maxdupler
 *
 */
public class Team {
    
    //initialize scanner for user input
    static Scanner in = new Scanner(System.in);
    
    /**.
     * the name of the team
     */
    private String teamName;
    
    /**.
     * holds the players on the team
     */
    protected ArrayList<Player> playerList;
    
    /**.
     * the amount of wins this season
     */
    private int wins;
    
    /**
     * the amount of losses this season
     */
    private int losses;
    
    /**.
     * the amount of ties this season
     */
    private int ties = 0;
    
    /**.
     * constructs a team with a given name 
     * @param name the team name
     */
    public Team(String name) {
        this.teamName = name;
        this.wins = 0;
        this.losses = 0;
        this.ties= 0;
        this.playerList = new ArrayList<Player>();
    }

    /**.
     * adds a game to the season
     */
    public void addGame() {
        
        //add a game played to each player
        for (Player elem : playerList) {
            elem.gamesPlayed += 1;
        }
        
        //calls method to handle the score and add stats
        processScore(); 
    }
    
    /**.
     * adds a skater to the team
     * @param name the name of the Skater
     * @param jerseyNum the jersey number of the Skater
     */
    public void addSkater(String name, int jerseyNum) {
        //make sure inputs are valid
        if (name.length() > 15) {
            System.out.print("The name " + name + " is too long, please enter"
                    + "a valid name: ");
            name = in.next() +  " " + in.next();
        }
        if (jerseyNum < 1 || jerseyNum > 99) {
            System.out.print("The jersey number " + jerseyNum 
                    + " must be 1 - 99, please enter a new one: ");
            jerseyNum = in.nextInt();
        }
        
        //create skater and add to the list
        playerList.add(new Skater(name, jerseyNum));
    }
    
    /**.
     * adds a Goalie to the team
     * @param name the name of the Goalie
     * @param jerseyNum the jersey number of the Goalie
     */
    public void addGoalie(String name, int jerseyNum) {
      //make sure inputs are valid
        if (name.length() > 15) {
            System.out.print("The name " + name + " is too long, please enter"
                    + "a valid name: ");
            name = in.next() + " " +  in.next();
        }
        if (jerseyNum < 1 || jerseyNum > 99) {
            System.out.print("The jersey number " + jerseyNum 
                    + " must be 1 - 99, please enter a new one: ");
            jerseyNum = in.nextInt();
        }
        
        //create and add goalie
        playerList.add(new Goalie(name, jerseyNum));
    }
    
    /**
     * Lists the players in order of number
     */
    public void listRoster() {
        skaterMenu();
        listSkaters();
        goalieMenu();
        listGoalies();
        
    }
    
    /**.
     * prints the header above the list of skaters
     */
    private void skaterMenu() {
        System.out.println("Skaters:");
        System.out.printf("%2s %-15s %3s %3s %3s %5s %3s\n", 
                "#", "Name", "G", "A", "P", "P/G", "PM");
    }
    
    /**.
     * lists all skaters without listing goalies
     */
    private void listSkaters() {
        //sort players so they are listed by number order
        numberSort();
        
        //list each player making sure they are a skater not goalie
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i) instanceof Skater) {
                System.out.println(playerList.get(i));
            }
        }
    }
    
    /**.
     * prints the header for the goalie stat list
     */
    private void goalieMenu() {
        System.out.println("Goalies");
        System.out.printf("%2s %-15s %3s %3s %5s %5s\n", "#", "Name", 
                "SV", "GA" ,"SV%", "GAA");
    }
    
    /**.
     * lists all goalies and their statistics
     */
    private void listGoalies() {
      //sort players so they are listed by number order
        numberSort();
        
        //list each player making sure they are a goalie not a skater
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i) instanceof Goalie) {
                System.out.println(playerList.get(i));
            }
        }
    }
    
    /**.
     * asks user for the score of the game and adjusts stats accordingly
     * @throws InputMismatchException
     */
    private void processScore() throws InputMismatchException {
        try {
            
            //ask how many our team scored
            System.out.print("How many goals did " + this.teamName 
                    + " score: ");
            int teamGoals = in.nextInt();
            
            //ask how many opposing team scored
            System.out.print("How many goals did the opposing team score: ");
            int oppGoals = in.nextInt();
            
          //check if this game is a win, loss, or tie
            winLoss(teamGoals, oppGoals);
            
            //ask how many shots were taken by opposing team
            System.out.print("How many shots were taken by the opposing team: ");
            int oppShots = in.nextInt();
            
            //enter goalie stats based on which goalie played
            goalieStats(oppGoals, oppShots);
            
            //if a goal was scored by the team, add the goals and assists
            if (teamGoals > 0) {
                playerGoals(teamGoals);
                playerAssists();
            }
            
            //add penalty min
            System.out.print("How many penalties did our team have: ");
            penalties(in.nextInt());
            
            
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
        }   
    }
    
    /**.
     * asks the user about penalties from the game and adds them to 
     * the season statistics
     * @param numPenalty the number of penalties taken in the game
     * @throws IndexOutOfBoundsException
     */
    private void penalties(int numPenalty) 
            throws IndexOutOfBoundsException {
        if (numPenalty > 0) {
            
            //ask the user which players have penalties
            System.out.print("Enter the jersey number(s) of the player(s) "
                    + "who got a penalty, if a player got more than one,"  
                    +" enter their jersey number for each penalty: ");
            
            //create an array with the jersey numbers of goal scorers
            ArrayList<Integer> penalty = new ArrayList<Integer>();
            
            for (int i = 0; i < numPenalty; i++) {
                penalty.add(in.nextInt());
            }
            
            //add a goal to each player who scored
            for (int i = 0; i < penalty.size(); i++) {
                try {
                    ((Player) playerList.get(numberSearch(
                            penalty.get(i)))).addPenaltyMin();
                } catch (IndexOutOfBoundsException e) {
                    System.out.print("The jersey number " + penalty.get(i)
                                    + " does not belong to "
                                    + "any player on this team, please enter"
                                    + " a valid number: ");
                    penalty.set(i, in.nextInt());
                    i--;
                }
            }
        }
    }
    
    /**.
     * adds a goal to each player who scored in the game
     * @param teamGoals the amount of goals scored by the team
     * @throws IndexOutOfBoundsException
     */
    private void playerGoals(int teamGoals) 
            throws IndexOutOfBoundsException {
        
        //ask the user which players scored
        System.out.print("Enter the jersey number(s) of the player(s) "
                + "who scored, \nif a player scored more than once,"  
                +"  enter their jersey number for each goal they scored: ");
        
        //arraylist to hold the scorers
        ArrayList<Integer> scorers = new ArrayList<Integer>();
        
        //add scorer numbers to list
        for (int i = 0; i < teamGoals; i++) {
            scorers.add(in.nextInt());
        }
        
        
        //add a goal to each player who scored
        for (int i = 0; i < scorers.size(); i++) {
            try {
                ((Skater) playerList.get(numberSearch(
                        scorers.get(i)))).addGoal();
            } catch (IndexOutOfBoundsException e) {
                System.out.print("The jersey number " + 
                    scorers.get(i) + " does not belong to"
                    + " any player on this team, please enter"
                    + " a valid number: ");
                scorers.set(i, in.nextInt());
                i--;
            }
        }
    }
    
    /**.
     * adds an assists to each player who got one in the game
     * @throws IndexOutOfBoundsException
     */
    private void playerAssists() 
            throws IndexOutOfBoundsException {
        
        //ask user how many assists were recorded in the game
        System.out.print("How many assists were there "
                + "(maximum 2 assists per goal: ");
        
        //holds the number of assists in the game
        int numAssist = in.nextInt();
       
        //if there was an assist or more than one ask the user which player(s) got one
        if (numAssist > 0) {
            System.out.print("Enter the jersey number(s) of the player(s) "
                    + "who had an assist, \nif a player had more than one,"  
                    +" enter their jersey number for each assist they had: ");
            
            //create arraylist of the jersey numbers of players who got an assist
            ArrayList<Integer> assists = new ArrayList<Integer>();
            
            for (int i = 0; i < numAssist; i++) {
                assists.add(in.nextInt());
            }
            
            //add an assist to each of the players
            for (int i = 0; i < assists.size(); i++) {
                try {
                    ((Skater) playerList.get(numberSearch(
                            assists.get(i)))).addAssist();
                } catch (IndexOutOfBoundsException e) {
                    System.out.print("The jersey number " + assists.get(i) 
                                    + " does not belong to "
                                    + " any player on this team, please enter"
                                    + " a valid number: ");
                    assists.set(i, in.nextInt());
                    i--;
                }
            }
        }
    }
    
    /**.
     * adds goalie stats after a game
     * @param goals an int
     * @param shots an int
     */
    private void goalieStats(int goals, int shots) 
            throws IndexOutOfBoundsException{
        
        //ask user which goalie played this game
        System.out.print("Enter the number of the goalie "
                + "who played this game: ");
        int goalieNum = in.nextInt(); 
        
        try {
            //make sure the user entered a valid goalie jersey number
            if (goalieNum == -1 
                    || !(playerList.get(numberSearch(goalieNum)) 
                            instanceof Goalie)) {
                System.out.print("There is no goalie on this team wearing "
                        + "this number, please try again");
                goalieStats(goals, shots);
            }
            
            //add the goals and shots
            ((Goalie) playerList.get(numberSearch(
                    goalieNum))).addGoalsAllowed(goals);
            ((Goalie) playerList.get(numberSearch(
                    goalieNum))).addSaves((shots - goals));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The jersey number " + goalieNum
                            + " does not belong to "
                            + " any Goalie on this team");
            goalieStats(goals, shots);
        }
    }
    
    /**.
     * determines if the team won, lost or tied and responds accordingly
     * @param teamGoals the amount of goals scored by the team
     * @param oppGoals the amount of goals scored by opponent
     */
    private void winLoss(int teamGoals, int oppGoals) {
        if (teamGoals < oppGoals) {
            System.out.println("Tough loss, better luck next time!");
            this.losses++;
        } else if (teamGoals == oppGoals) {
            System.out.println("At least it's not a loss!");
            this.ties++;
        } else {
            System.out.println("Great Win!");
            this.wins++;
        }
        System.out.println(this.teamName + " current record: " 
                + this.wins + "-" + this.losses + "-" 
                + this.ties);
    }
    
    /**.
     * sorts the players by jersey number
     */
    private void numberSort() {
        // sorting algorithm
        for (int i = 0; i < playerList.size(); i++) {
            Player p1 = playerList.get(i);
            for (int j = i + 1; j < playerList.size(); j++) {
                Player p2 = playerList.get(j);
                if (p1.getJerseyNum() > p2.getJerseyNum()) {
                    playerList.set(i, p2);
                    playerList.set(j, p1);
                    p1 = p2;
                }
            }
        }
            
    }
    
    /**.
     * finds the index of a player on the team when given the jersey num
     * @param num an int
     * @return an int value
     */
    @SuppressWarnings("unused")
    private int numberSearch(int num) {
        //search algorithm
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getJerseyNum() == num) {
                return i;
            }
        }
        return -1;
    }
}
