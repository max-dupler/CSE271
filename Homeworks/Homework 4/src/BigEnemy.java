import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * . Creates and stores info about a big enemy
 * 
 * @author maxdupler
 *
 */
public class BigEnemy extends Enemy {

    /**.
     * Serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * . random instance
     */
    private static final Random r = new Random();

    /**
     * . creates a BigEnemy with random x and y coordinates
     * 
     * @param panelWidth  the width of the panel of the game
     * @param panelHeight the height of the panel of the game
     */
    public BigEnemy(int panelWidth, int panelHeight) {
        super(r.nextInt(panelWidth - 56),
                r.nextInt(panelHeight - 56), 56, 56, 4);

        setColor();
    }

    /**
     * . generates a random color and fills in the enemy with that color
     */
    @Override
    public void setColor() {
        Color random = new Color(r.nextInt(256),
                r.nextInt(256), r.nextInt(256));
        setEnemyColor(random);
    }

    /**
     * . moves the enemy
     * 
     * @param width  the width of the panel
     * @param height the height of the panel
     */
    @Override
    public void move(int width, int height) {
        //reverses speed when an enemy hits a border
        if (this.getX() + this.getEnemySpeed() > width 
                || this.getX() + this.getEnemySpeed() < 0) {
            this.setEnemySpeed(this.getEnemySpeed() * -1);
        }
        //sets new bounds
        this.setBounds((int) (this.getX() + this.getEnemySpeed()),
                this.getY(), 56, 56);
    }

    /**
     * . processes a collision between the enemy and a missile
     * 
     * @param list an arraylist of the enemies
     * @param the  index of the enemy hit
     */
    @Override
    public void processCollision(ArrayList<Enemy> list, int bigEnemy) {
        //decreases width and height
        this.setBounds(this.getX(), this.getY(), this.getWidth() - 20,
                this.getHeight() - 20);
        //checks if the enemy needs to be removed
        if (this.getWidth() <= 0 || this.getHeight() <= 0) {
            list.remove(bigEnemy);
        }

    }

}
