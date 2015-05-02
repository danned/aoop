//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//
// Class          : bouncingBalls.Controller
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
//   The Controller for the bouncingBalls package supplies several
// buttons and also sets a timer to update and display the model
// regularly, to create the animation effect.
//
//   Note that "no access modifier" means that the method is package
// friendly: this means the member is public to all other classes in
// the calculator package, but private elsewhere.
//
// Future Plans   : More Comments
//
// Program History:
//   10/20/01: R. Pattis - Operational for 15-100
//
//
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////



package bouncingBalls;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.Timer;



public class Controller
{

  //Trivial constructor (could be automatically supplied by Java)
  public Controller()
  {}


  
  //Refer to the model (for scheduling updateAll) 
  public void addModel(Model m)
  {model = m;}


  
  //Refer to the View (for scheduling repaint) 
  public void addView(View v)
  {view = v;}

  
  
  //Build/Return a Reset button
  JButton getResetButton()
  {
	  JButton b = new JButton();
	  
	  b.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e)
		  {
		    System.out.println("Debug-Controller: " + "Reset button pressed");
        model.reset();
      }});
	  
	  return b;
  }
    


  //Build/Return a Start button
  JButton getStartButton()
  {
	  JButton b = new JButton();
	  
	  b.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e)
		  {
		    System.out.println("Debug-Controller: " + "Start button pressed");
        model.start();
      }});
	  
	  return b;
  }
    


  //Build/Return a Stop button
  JButton getStopButton()
  {
	  JButton b = new JButton();
	  
	  b.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e)
		  {
		    System.out.println("Debug-Controller: " + "Stop button pressed");
        model.stop();
      }});
	  
	  return b;
  }
    


  //Build/Return a mouse controller to atttach to the BallPanel
  MouseListener getBallPanelMouseListener()
  {
    return
      new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) 
        {
		      System.out.println("Debug-Controller: Mouse clicked ("
		                         +evt.getClickCount()+") at ("+evt.getX()+","
		                         +evt.getY()+")");
          model.mouseClick(evt.getX(),evt.getY(),evt.getClickCount());
        }};
  }




	void animate ()
	{
	  //A bit of magic
	  //Create an action listener, overriding its actionPerformed
	  //  method to update the model and repaint the view
	  //Then, create a timer (from the javax.swing package!), so that
	  //  every 100ms (10 times a second) it performs actionPerformced,
	  //  and start the timer.
	  //The Java systems keeps track of this object once it is
	  //  constructed and started (even if the tempTimer variable
	  //  goes away, as it does when this method terminates).
	  ActionListener updater = new ActionListener() {
		  public void actionPerformed(ActionEvent e)
			{
				model.updateAll();
				view.repaint();
			}};
			
		Timer tempTimer = new Timer(100, updater);
		tempTimer.start();
  }
    
 
 
   
    
  //Instance Variables
  
  private Model model;
  private View  view;
}


