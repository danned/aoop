//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//
// Class          : bouncingBalls.Model
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
//   The Model for the bouncingBalls package implements an array of
// moveable objects, each with an x,y coordinate, a speed (dx,dy), and 
// an image. It applies its methods to all the ball objects: e.g.,
// when updateAll is called, it calls update on all the objects in
// the array.
// 
//   Note that "no access modifier" means that the method is package
// friendly: this means the member is public to all other classes in
// the calculator package, but private elsewhere.
//
// Future Plans   : None
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



public class Model
{

  public Model()
  {reset();}
  
  
  
  //Refer to the view (used to call update in view; also see updateAll)
  public void addView(View v)
  {view = v;}
   
   
 
  //Start with no balls (but room for one) 
  void reset ()
  {
    running    = false;
    cycleCount = 0;
    used       = 0;
    balls      = new Ball[1];
  }

     
      
  //Add a ball to the simulation at the clicked location, with
  //  random values establishing its speed.
  //Ensure there is enough room in the balls array first   
  void mouseClick(int x, int y, int clickCount)
  { 
    if (used == balls.length)
      doubleLength();
    balls[used++] = new Ball(x,y,
                             randomInRange(-10,10), randomInRange(-10,10),
                             randomColor());
  }
  
  
  
  //If the model is running, update the positions of all the
  //  balls in the array
  //Called at regular intervals by the Controller
  void updateAll()
  {
    if (!running)
      return;
      
    cycleCount++;
    for (int i=0; i<used; i++) {
      Ball one = balls[i];
      for (int j = 0; j < used; j++) {
        if(balls[i].isCloseTo(balls[j])){
          //Do fusing; fusing means the average of their velocities and color.
          System.out.println(balls[i] + "\nIS CLOSE TO\n" + balls[j] + "\n\n");
        }
      }
      one.update(view.getEnclosingBox());

    }
      
    //System.out.println("State: " + this +"\n");
  }

    
  
  //Display the positions of all the balls in the array
  //Called at regular intervals by the Controller
  void displayAll(Graphics g)
  {
    for (int i=0; i<used; i++)
      balls[i].display(g);
  }


  
  //Start button pushed: ensure state of runing is true
  void start ()
  {running = true;}
  
  
  
  //Start button pushed: ensure state of runing is false
  void stop ()
  {running = false;}

  
  
  //The View calls these accessors information to display
  //  (besides the images of all the balls)
  int getCycleCount()
  {return cycleCount;}  

  int getBallCount()
  {return used;}  



  //Standard toString method
  public String toString()
  {
    String answer = "Model[used="+used+",running="+running+",cycleCount="+cycleCount;
    for (int i=0; i<used; i++)
      answer+=",\n  balls["+i+"]="+balls[i];
    return answer+"\n]";
  }
  
  

  //Helper methods (all static)
  private static int randomInRange(int low, int high)
  {return low + (int)(Math.random()*(high-low+1));}
  
  private static Color randomColor()
  {
    return new Color( randomInRange(0,255),
                      randomInRange(0,255),
                      randomInRange(0,255) );
  }
  
 
 
  private void doubleLength()
  {
    Ball[] temp = new Ball[2*used];
    for (int i=0; i<used; i++)
      temp[i] = balls[i];
    balls = temp;
  }
      
 
        
  //Instance Variables
  
  private View view;         // Model must tell View when to update itself
    
  private Ball[]     balls;       //Refer to each ball
  private int        used;        //How much of the balls array is used
  private boolean    running;     //Whether updateAll should update balls
  private int        cycleCount;  //Times updateAll called since reset
}


