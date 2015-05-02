//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//
// Class          : bouncingBalls.Ball
//
// Author         : Richard E. Pattis
//                  Computer Science Department
//                  Carnegie Mellon University
//                  5000 Forbes Avenue
//                  Pittsburgh, PA 15213-3891
//                  e-mail: pattis@cs.cmu.edu
//
// Maintainer     : Author
//
//
// Description:
//
//   The Ball class for the bouncingBalls package implements a single
// ball: its state includes its x,y coordinate, a speed (vx,vy), and an
// image color. It defines update and display methods.
// 
//   Note that "no access modifier" means that the method is package
// friendly: this means the member is public to all other classes in
// the calculator package, but private elsewhere.
//
// Future Plans   : More Comments; use BigInteger?
//
// Program History:
//   9/20/01: R. Pattis - Operational for 15-100
//
//
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////



package bouncingBalls;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class Ball {

  //Constructor
  Ball (int x, int y, int vx, int vy, Color color)
  {
    this.x     = x;
    this.y     = y;
    this.vx    = vx;
    this.vy    = vy;
    this.color = color;
  }


  //Update this ball's x,y coordinates
  void update(Dimension box)
  {
     x += vx;
     y += vy;
    
     //Correct to have hit wall (if outside the box horizontally)
     if (x < 0) {
       vx = Math.abs(vx);
       x  = -x;
     }else if (x+ballDimensions.width > box.width) {
       vx = -Math.abs(vx);
       x  -= (x+ballDimensions.width)-box.width;
     }
    
     //Correct to have hit wall (if outside the box vertically)
     if (y < 0) {
       vy = Math.abs(vy);
       y  = -y;
     }else if (y+ballDimensions.height > box.height) {
       vy = -Math.abs(vy);
       y  -= (y+ballDimensions.height)-box.height;
     }
   }

    //Compares one ball with another Ball to see of it's close, returns true if so
    boolean isCloseTo(Ball other){
        return  this.x + 2 > other.x &&
                this.x - 2 < other.x &&
                this.y + 2 > other.y &&
                this.y - 2 < other.y;
    }

    
    
  //Display this ball as a circle filled with its color
  void display(Graphics g)
  {
    g.setColor(color);
    g.fillOval(x,y,ballDimensions.width,ballDimensions.height);
  }



  public String toString ()
  {return "Ball[x="+x+",y="+y+",vx="+vx+",vy="+vy+",color="+color+"]";}
  
  
    
  //Fields 
  private       int   x, y, vx, vy;
  private final Color color;
  
  //All balls are this size (see display)
  private static Dimension ballDimensions = new Dimension(10,10);
}
