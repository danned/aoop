/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author Daniel
 */
public class PuzzleBoard extends JComponent {
    //public Tile[][] tiles;
    private Tile[][]tiles;
    int x;
    int y;
    public PuzzleBoard()
    {
        /*tiles = new Tile[16];
        for(int i = 0; i < 16;i++)
        {
            tiles[i] = (new Tile(i%4, (i)/4 , (i)));
        }*/
        tiles = new Tile[4][4];
        for(int y = 1; y< 5; y++)
        {
            for(int x = 1; x < 5; x++)
            {
                tiles[y-1][x-1] = new Tile(x,y, (x+(y-1)*4)-1 );
            }
            //tiles[i] = (new Tile(i%4, (i)/4 , (i)));
        }
        x = 0;
        y = 0;
    }
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //g2.drawRect(100, 100, 100, 100);
        g2.setColor(Color.black);
        //g2.fillRect(200, 200, 200, 200);
        /*for(Tile t:tiles)
        {
            t.draw(g2, this.getSize());
        }*/
        for(Tile y[] : tiles)
        {
            for(Tile x: y)
            {
                x.draw(g2, this.getSize());
            }
        }
        
   }
   
    public boolean moveEast()
    {
        if(x < 3)
        {
            tiles[y][x].moveEast();
            tiles[y][x+1].moveWest();
            Tile tmp = tiles [y][x]; 
            tiles[y][x] = tiles[y][x+1];
            tiles[y][x+1] = tmp;
            x++;
            repaint();
            return true;
        }else
        {
            return false;
        }
    }
    public boolean moveWest()
    {
        if(x > 0)
        {
            tiles[y][x].moveWest();
            tiles[y][x-1].moveEast();
            Tile tmp = tiles [y][x]; 
            tiles[y][x] = tiles[y][x-1];
            tiles[y][x-1] = tmp;
            x--;
            repaint();
            return true;
        }else
        {
            return false;
        }
    }
    
    public boolean moveSouth()
    {
        if(y<3)
        {
            tiles[y][x].moveSouth();
            tiles[y+1][x].moveNorth();
            Tile tmp = tiles [y][x]; 
            tiles[y][x] = tiles[y+1][x];
            tiles[y+1][x] = tmp;
            y++;
            repaint();
            return true;
        }else
        {
            return false;
        }
    }
    public boolean moveNorth()
    {
        if(y>0)
        {
            tiles[y][x].moveNorth();
            tiles[y-1][x].moveSouth();
            Tile tmp = tiles [y][x]; 
            tiles[y][x] = tiles[y-1][x];
            tiles[y-1][x] = tmp;
            y--;
            repaint();
            return true;
        }else
        {
            return false;
        }
    }
}
