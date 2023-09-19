import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * . creates and stores info about a small enemy
 * 
 * @author maxdupler
 *
 */
public class SmallEnemy extends Enemy {

    /**
     * . Serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * . Random instance
     */
    private static Random r = new Random();

    /**
     * . creates a SmallEnemy with random x and y coordinates
     * 
     * @param panelWidth  the width of the panel of the game
     * @param panelHeight the height of the panel of the game
     */
    public SmallEnemy(int panelWidth, int panelHeight) {
        super(r.nextInt(panelWidth - 30),
                r.nextInt(panelHeight - 30), 30, 30, 6);

        setColor();
    }

    @Override
    public void setColor() {
        Color random = new Color(r.nextInt(256),
                r.nextInt(256), r.nextInt(256));
        setEnemyColor(random);
    }

    @Override
    public void move(int width, int height) {
        // reverse the speed if needed
        if (this.getX() + this.getEnemySpeed() > width
                || this.getX() + this.getEnemySpeed() < 0) {
            this.setEnemySpeed(this.getEnemySpeed() * -1);
        }
        // set new bounds
        this.setBounds((int) (this.getX() + this.getEnemySpeed()),
                this.getY(), this.getWidth(), this.getHeight());
        // increase speed
        if (this.getEnemySpeed() >= 0) {
            this.setEnemySpeed(this.getEnemySpeed() + .05);
        } else {
            this.setEnemySpeed(this.getEnemySpeed() - .05);
        }
    }

    @Override
    public void processCollision(ArrayList<Enemy> list, int smallEnemy) {
        // decrease size
        this.setBounds(this.getX(), this.getY(), this.getWidth() - 10,
                this.getHeight() - 10);
        // remove enemy once size is 0
        if (this.getWidth() <= 0 || this.getHeight() <= 0) {
            list.remove(smallEnemy);
        }
    }
}
