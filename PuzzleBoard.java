/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Collections;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel and Erik
 */
public class PuzzleBoard extends JComponent {
    //public Tile[][] tiles;
    private Tile[][]tiles;
    int x;
    int y;
    public PuzzleBoard()
    {
        ArrayList<Tile> tmp = new ArrayList<>();
        for(int i = 0; i<16;i++){ tmp.add(new Tile(0,0,i)); }
        //tmp.add(new Tile(0,0,0));
        Collections.shuffle(tmp);
        tiles = new Tile[4][4];

        for(int i = 0;i<tmp.size();i++){
            tiles[i/4][i%4] = tmp.get(i);
            tiles[i/4][i%4].setY(i/4+1);
            tiles[i/4][i%4].setX(i%4+1);
            if( tiles[i/4][i%4].getValue() == 0)
            {
                y = i/4;
                x = i%4;
            }
        }
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
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
            checkWin();
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
            checkWin();
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
            checkWin();
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
            checkWin();
            return true;
        }else
        {
            return false;
        }
    }
    
    private void checkWin()
    {
        boolean win = true;
        for(int i = 0;i<15 && win;i++){
            if( tiles[i/4][i%4].getValue() != i+1) win = false;  
        }
        
        if(win)
        {
           JOptionPane.showMessageDialog(new JFrame(),
                "You Win!"); 
        }
    }
}
