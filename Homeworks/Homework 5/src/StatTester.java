
public class StatTester {
    public static void main(String[] args) {
        //create Team
        Team teamA = new Team("Team A");
        //add players and goalie
        teamA.addSkater("Max Dupler", 10);
        teamA.addSkater("John Smith", 49);
        teamA.addSkater("Jack Marting", 59);
        
        teamA.addGoalie("Goalie Man", 35);
                
        teamA.listRoster();
        
        teamA.addGame();
        
        teamA.listRoster();
        
    }
}
