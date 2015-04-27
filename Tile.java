package presenter;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author Daniel
 */
public class Tile{
    private final int value;
    int x;
    int y;
    
    public Tile(int x, int y, int val)
    {
        value = val;
        this.x = x;
        this.y = y;
    }
    
    public int getValue()
    {
        return value; //integers are immutable. returns object
    }
    
    public void draw(Graphics2D g2d,Dimension d)
    {
        int dx = (int)d.getWidth()/5;
        int dy = (int)d.getHeight()/5;
        if(value != 0){
            g2d.drawString(Integer.toString(value), x*dx, y*dy);
        }
        g2d.drawRect(x*dx-dx/2, y*dy-dy/2, dx, dy);
    }
    public int getY()
    {
        return y;
    }
    
    public int getX()
    {
        return x;
    }
    public void moveEast(){
        this.x++;
    }
    public void moveWest()
    {
        this.x--;
    }
    public void moveNorth(){
        this.y--;
    }
    public void moveSouth()
    {
        this.y++;
    }
}
