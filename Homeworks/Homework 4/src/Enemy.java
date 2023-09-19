import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * . creates and stores info about an Enemy
 * 
 * @author maxdupler
 *
 */
public abstract class Enemy extends JComponent {

    /**.
     * serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * . stores the speed that the enemy moves at
     */
    private double enemySpeed;

    /**
     * . stores the color of the enemy
     */
    private Color enemyColor;

    /**
     * . Constructs an enemy
     * 
     * @param x          the x coordinate of the enemy location
     * @param y          the y coordinate of the enemy location
     * @param height     the height of the enemy
     * @param width      the width of the enemy
     * @param enemySpeed the speed at which the enemy can move
     */
    public Enemy(int x, int y, int height, int width, double enemySpeed) {
        super.setBounds(x, y, width, height);

        this.enemySpeed = enemySpeed;
    }

    /**
     * . determines what happens when a missile hits an enemy
     * 
     * @param list  the list of enemies in the game
     * @param enemy the enemy hit
     */
    public abstract void processCollision(ArrayList<Enemy> list, int enemy);

    /**
     * . generates and sets the color of the enemy
     */
    public abstract void setColor();

    /**
     * . computes and updates the enemy's next position
     * 
     * @param width  the specified width the enemy must stay in
     * @param height the specified height the enemy must stay in
     */
    public abstract void move(int width, int height);

    public void paintComponents(Graphics g) {
        Rectangle r = this.getBounds();
        g.setColor(getEnemyColor());
        g.fillOval(r.x, r.y, r.height, r.width);
    }

    /**
     * . returns the speed of the enemy
     * 
     * @return a double type
     */
    public double getEnemySpeed() {
        return this.enemySpeed;
    }

    /**
     * . sets the speed of the enemy
     * 
     * @param speed a double type
     */
    public void setEnemySpeed(double speed) {
        this.enemySpeed = speed;
    }

    /**
     * . returns the color of the enemy
     * 
     * @return a Color type
     */
    public Color getEnemyColor() {
        return this.enemyColor;
    }

    /**
     * . sets the color of the enemy
     * 
     * @param c a Color type
     */
    public void setEnemyColor(Color c) {
        this.enemyColor = c;
    }
}
