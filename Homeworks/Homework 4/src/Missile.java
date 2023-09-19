import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

/**
 * . Creates and stores info about a missile
 * 
 * @author maxdupler
 *
 */
public class Missile extends JComponent {

    /**.
     * serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * . random instance
     */
    private static final Random r = new Random();

    /**
     * . stores the speed of the missile
     */
    private int missileSpeed;

    /**
     * . stores the color of the missile
     */
    private Color missileColor;

    /**
     * . missile constructor
     * 
     * @param x the x coordinate of the missile
     * @param y the y coordinate of the missile
     */
    public Missile(int x, int y) {
        super.setBounds(x, y, 15, 15);
        this.missileSpeed = 5;
        this.missileColor = new Color(r.nextInt(256),
                r.nextInt(256), r.nextInt(256));
    }

    /**
     * . sets the missileColor to a random color
     */
    public void setMissileColor() {
        this.missileColor = new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random());
    }

    /**
     * . paints the missile the random color assigned to missileColor
     */
    public void paintComponents(Graphics g) {
        Rectangle r = this.getBounds();
        g.setColor(this.missileColor);
        g.fillOval(r.x, r.y, r.height, r.width);
    }

    /**.
     * moves the missile
     * 
     * @param width   the width of the panel
     * @param height  the height of the panel
     * @param list    the array list of missiles
     * @param missile the index of the missile to be moved
     */
    public void move(int width, int height, ArrayList<Missile> list,
            int missile) {
        // sets new bounds
        this.setBounds(this.getX(), this.getY() - missileSpeed, 15, 15);
        // remove the missile if it hits the top border
        if (this.getY() > height || this.getY() < 0) {
            list.remove(missile);
        } 
    }

    /**
     * . returns the missile speed
     * 
     * @return and int type
     */
    public int getMissileSpeed() {
        return this.missileSpeed;
    }
}
